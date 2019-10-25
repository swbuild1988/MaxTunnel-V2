package com.bandweaver.maxtunnelshiro.controller;

import com.bandweaver.maxtunnelcommon.utils.R;

import com.bandweaver.maxtunnelshiro.configuration.JwtConstants;
import com.bandweaver.maxtunnelshiro.configuration.JwtUtil;
import com.bandweaver.maxtunnelshiro.configuration.RedisUtil;
import com.bandweaver.maxtunnelshiro.entity.SecurityUser;
import com.bandweaver.maxtunnelshiro.entity.User;
import com.bandweaver.maxtunnelshiro.service.RabbitMqService;
import com.bandweaver.maxtunnelshiro.service.SecurityUserService;
import com.bandweaver.maxtunnelshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/shiro")
public class LoginController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SecurityUserService securityUserService;

    @Value("${bandweaver.redis.permissionKey}")
    String permissionKey;


    @RequestMapping("/login")
    public R login(HttpServletRequest request, @RequestBody SecurityUser user) {// 登录测试
        log.info("----- 登录 ------");
        try {
            String authToken = request.getParameter("Authorization");
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPassword());
            subject.login(usernamePasswordToken);
            Session session = subject.getSession();
            user = (SecurityUser) session.getAttribute("userInfo");
            Set<String> permissions = (Set<String>) session.getAttribute("userPermission");
            log.info("=====userPermission =====" + permissions.toString());

            Map<String, Object> result = new HashMap<>();
            //登录成功后
            if(StringUtils.isNotBlank(authToken)){
                boolean isExpried = JwtUtil.isTokenExpired(authToken);
                if(isExpried){ //token过期
                    String oldQueueName = JwtUtil.getPrivateClaimsFromToken(authToken,"queueName");
                    rabbitMqService.deleteQueue(oldQueueName);
                    //生成新的token
                    String queueName = rabbitMqService.createQueue();
                    Map<String, Object> map = new HashMap<>();
                    map.put("username", user.getName());
                    map.put("queueName",queueName);
                    String token = JwtUtil.createJwt(map);

                    result.put("token", token);
                    result.put("userId", user.getUserId());
                    result.put("queueName", queueName);
                    result.put("userPermission", permissions);
                }else{
                    result.put("token", authToken);
                    result.put("userId", user.getUserId());
                    result.put("userPermission", permissions);
                }
            }else{
                // 登陆的时候创建一个消息队列并将名字返回给前端
                String queueName = rabbitMqService.createQueue();
                Map<String, Object> map = new HashMap<>();
                map.put("username", user.getName());
                map.put("queueName",queueName);
                String token = JwtUtil.createJwt(map);

                result.put("token", token);
                result.put("userId", user.getUserId());
                result.put("queueName", queueName);
                result.put("userPermission", permissions);
            }

            return new R(result,"success");
        } catch (IncorrectCredentialsException e) {
            //密码错误
            return new R(500, "用户名或密码错误");
        } catch (UnknownAccountException e) {
            //用户不存在
            return new R(500, "用户不存在");
        }catch (Exception e){
            //其他错误
            return new R(500, "账号有误");
        }

    }
    @GetMapping("/logout")
    public R logOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String token = httpServletRequest.getHeader(JwtConstants.AUTH_HEADER);
        String queueName = JwtUtil.getPrivateClaimsFromToken(token,"queueName");
        rabbitMqService.deleteQueue(queueName);
        return new R(200);
    }

    @RequestMapping("/permissions")
    public Set<String> getAuthorityByUser(String userName) {
        Subject currentUser = SecurityUtils.getSubject();
        String REDIS_KEY = userName + "." + permissionKey;
        Set<String> permissions = new HashSet<>();
        if(redisUtil.hasKey(REDIS_KEY)){
            permissions = redisUtil.sMembers(REDIS_KEY);
        }else{
            permissions = securityUserService.getUserPermissions(userName);
        }

//        Set<String> permissions = (Set<String>) currentUser.getSession().getAttribute("userPermission");
//        log.info("=======  userService   ======== ");
//        Set<String> permissions2 = securityUserService.getUserPermissions("admin");
        log.info("=== permissions ===" + permissions.toString());

        return permissions;
    }

    @GetMapping("/redis")
    public String getRedis(@RequestParam("key") String key) {
        String redisKey = redisUtil.get(key);
        return redisKey;
    }

    @RequestMapping("/say")
    public String getSay() {
        String result = "welcome to shiro ";
        return result;
    }


}
