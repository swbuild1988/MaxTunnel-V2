package com.bandweaver.maxtunnelomm.controller;

import com.bandweaver.maxtunnelfeign.em.RemoteUserService;
import com.bandweaver.maxtunnelfeign.vo.R;
import com.bandweaver.maxtunnelfeign.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/feigntest")
public class FeignTestController {

    @Resource
    private RemoteUserService remoteUserService;


    @RequestMapping("/testlogin")
    public R userLogin(Integer id){
        return remoteUserService.userLogin(id);
    }

    @RequestMapping("/list")
    public List<User> pageList(){
        return remoteUserService.pageList();
    }




}
