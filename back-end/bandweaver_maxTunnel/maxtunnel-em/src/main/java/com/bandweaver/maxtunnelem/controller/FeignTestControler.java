package com.bandweaver.maxtunnelem.controller;

import com.bandweaver.maxtunnelfeign.omm.RemoteHelloService;
import com.bandweaver.maxtunnelfeign.shiro.RemoteShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/feigntest")
public class FeignTestControler {

    @Autowired
    private RemoteHelloService remoteHelloService;

    @Autowired
    private RemoteShiroService remoteShiroService;

    @RequestMapping("/list")
    public List<String> getUserList(){
        return remoteHelloService.getUserList();
    }


    @RequestMapping("/say")
    public String sayHello(){
        return remoteHelloService.sayHello();
    }

    @RequestMapping("/shrioSay")
    public String sayShiroHello(){
        return remoteShiroService.sayHello();
    }

}
