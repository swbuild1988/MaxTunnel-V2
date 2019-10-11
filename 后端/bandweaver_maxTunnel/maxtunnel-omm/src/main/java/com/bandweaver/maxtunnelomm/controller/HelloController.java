package com.bandweaver.maxtunnelomm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/list")
    public List<String> getUserList(){
        List<String> result = new ArrayList<String>();
        result.add("张三丰");
        result.add("张无忌");
        result.add("令狐冲");
        result.add("周伯通");
        result.add("东方不败");

        return result;
    }

    @RequestMapping("/say")
    public String sayHello(){
        String result = "welcome to shanghai !!!";
        return result;
    }


}
