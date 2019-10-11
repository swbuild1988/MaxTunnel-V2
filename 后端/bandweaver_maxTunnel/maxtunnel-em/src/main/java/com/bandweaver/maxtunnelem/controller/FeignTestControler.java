package com.bandweaver.maxtunnelem.controller;

import com.bandweaver.maxtunnelfeign.omm.RemoteHelloService;
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

    @RequestMapping("/list")
    public List<String> getUserList(){
        return remoteHelloService.getUserList();
    }


    @RequestMapping("/say")
    public String sayHello(){
        return remoteHelloService.sayHello();
    }


}
