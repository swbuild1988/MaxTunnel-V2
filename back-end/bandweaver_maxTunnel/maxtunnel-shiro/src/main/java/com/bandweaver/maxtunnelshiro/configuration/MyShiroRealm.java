package com.bandweaver.maxtunnelshiro.configuration;

import com.bandweaver.maxtunnelshiro.entity.SecurityUser;
import com.bandweaver.maxtunnelshiro.entity.User;
import com.bandweaver.maxtunnelshiro.service.SecurityUserService;
import com.bandweaver.maxtunnelshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${bandweaver.redis.permissionKey}")
    String permissionKey;


    //认证：用户身份识别，通常被称为用户“登录”
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        SecurityUser user = securityUserService.getByUserName(token.getUsername());
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        //登录验证
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), super.getName());
        // 保存用户信息到session中
        SecurityUtils.getSubject().getSession().setAttribute("userInfo", user);
        Set<String> permissionSet = securityUserService.getUserPermissions(token.getUsername());
        String REDIS_KEY = token.getUsername() + "." + permissionKey;
        if(!redisUtil.hasKey(REDIS_KEY)){
            for (String permission : permissionSet) {
                redisUtil.sAdd(REDIS_KEY, permission);
                // 设置缓存过期时间
                redisUtil.expire(REDIS_KEY,30, TimeUnit.MINUTES);
            }
        }
        SecurityUtils.getSubject().getSession().setAttribute("userPermission", permissionSet);

        return authcInfo;
    }

    //（授权）：访问控制。比如某个用户是否具有某个操作的使用权限。
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        String REDIS_KEY = userName + "." + permissionKey;
        Set<String> permissionSet = new HashSet<>();
        if (redisUtil.hasKey(REDIS_KEY)) {
            // 从缓存中获取权限信息
            permissionSet = redisUtil.sMembers(REDIS_KEY);
            log.info("从redis缓存中命中:" + permissionSet);
        } else {
            // 如果没有，则需要从数据库查询，并同步到redis缓存中
            permissionSet = securityUserService.getUserPermissions(userName);
            log.info("从DB查询用户" + userName + "权限为：" + permissionSet);
            for (String permission : permissionSet) {
                redisUtil.sAdd(REDIS_KEY, permission);
                // 设置缓存过期时间
                redisUtil.expire(REDIS_KEY,30, TimeUnit.MINUTES);
            }
        }
        SecurityUtils.getSubject().getSession().setAttribute("userPermission", permissionSet);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permissionSet);
        return authorizationInfo;
    }


}
