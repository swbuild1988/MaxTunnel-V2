package com.bandweaver.maxtunnelem.controller;

import com.bandweaver.maxtunnelcommon.utils.R;
import com.bandweaver.maxtunnelem.entity.User;
import com.bandweaver.maxtunnelem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

}
