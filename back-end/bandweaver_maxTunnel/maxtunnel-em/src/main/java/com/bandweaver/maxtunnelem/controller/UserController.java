package com.bandweaver.maxtunnelem.controller;

import com.bandweaver.maxtunnelcommon.utils.R;
import com.bandweaver.maxtunnelem.configuration.RedisUtil;
import com.bandweaver.maxtunnelem.entity.SecurityUser;
import com.bandweaver.maxtunnelem.entity.User;
import com.bandweaver.maxtunnelem.service.SecurityUserService;
import com.bandweaver.maxtunnelem.service.UserService;
import com.bandweaver.maxtunnelfeign.shiro.RemoteShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RemoteShiroService remoteShiroService;

    @RequestMapping("/login")
    public R userLogin(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token","123454555");
        map.put("userName","zhangsan");
        map.put("queueName","zhangsan-12344");
        return new R(map);
    }

    @RequestMapping("/list")
    public List<User> pageList(){
        List<User> userList = userService.listAllUser();
        return userList;
    }

    @RequestMapping("/getUser")
    public R getUser(Integer id){
        User user = userService.selectByUserId(id);
        return new R(user);
    }

    @RequestMapping("/test")
    public R test(Integer id){
        Integer[] integers = {1,2,3,4,5,6};
        return new R(integers);
    }

    @GetMapping("/redis")
    public String getRedis(String key) {
        String redisKey = redisUtil.get(key);
        return redisKey;
    }

    @RequestMapping("/list2")
    public List<SecurityUser> pageList2(){
        List<SecurityUser> userList = securityUserService.listAllUser();
        return userList;
    }

    @RequestMapping("/permissions")
    public Set<String> getAuthorityByUser(String name){
        Set<String> result = remoteShiroService.getAuthorityByUser(name);
        return result;
    }

    @GetMapping("/shiroRedis")
    public String getShiroRedis(@RequestParam("key") String key){
        String result = remoteShiroService.getRedis(key);
        return result;
    }

}
