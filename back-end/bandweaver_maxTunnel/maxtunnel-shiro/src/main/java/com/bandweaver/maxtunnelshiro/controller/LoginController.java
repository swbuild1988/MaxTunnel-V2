package com.bandweaver.maxtunnelshiro.controller;

import com.bandweaver.maxtunnelcommon.utils.R;
import com.bandweaver.maxtunnelshiro.configuration.RedisUtil;
import com.bandweaver.maxtunnelshiro.entity.User;
import com.bandweaver.maxtunnelshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/shiro")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/login")
    public R login(@RequestBody User user) {// 登录测试
        log.info("----- 登录 ------");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        try {
            currentUser.login(token);
            Set<String> permissions = (Set<String>) currentUser.getSession().getAttribute("userPermission");
            log.info("=====userPermission =====" + permissions.toString());

            return new R(200,"success");
        }catch (Exception e){
            //其他错误
            return new R(500);
        }
//        } catch (IncorrectCredentialsException e) {
//            //密码错误
//            return new Response(CodeEnum.AUTH_UNMATCH, null);
//        }
//        catch (UnknownAccountException e) {
//            //用户不存在
//            return new Response(CodeEnum.USER_IS_NOT_EXISTS, null);
//        }
//        catch (DisabledAccountException e) {
//            //用户已停用
//            return new Response(CodeEnum.STOP_USE, null);
//
//        } catch (ExcessiveAttemptsException e) {
//            //用户被锁定
//            return new Response(CodeEnum.AUTH_LOCKED, null);
//        }catch (Exception e){
//            //其他错误
//            return new Response(CodeEnum.ERR_STATUS, null);
//        }

    }
    @GetMapping("/logout")
    public R logOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new R(200);
    }

    @GetMapping("/permissions")
    public Set<String> getAuthorityByUser(String userName) {
        Subject currentUser = SecurityUtils.getSubject();
        Set<String> permissions = (Set<String>) currentUser.getSession().getAttribute("userPermission");
        log.info("=======  userService   ======== ");
        Set<String> permissions2 = userService.getUserPermissions("admin");
        log.info("=== admin.permissions2 ===" + permissions2.toString());

        return permissions;
    }

    @GetMapping("/redis")
    public String getRedis(String key) {
        String redisKey = redisUtil.get(key);
        return redisKey;
    }


}
