package com.bandweaver.maxtunnelfeign.omm;


import com.bandweaver.maxtunnelfeign.constants.ServiceNameConstant;
import com.bandweaver.maxtunnelfeign.omm.fallback.RemoteHelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = ServiceNameConstant.OMM_SERVICE,
        path = "/hello", fallback = RemoteHelloServiceFallback.class)
public interface RemoteHelloService {

    @RequestMapping("/list")
    List<String> getUserList();

    @RequestMapping("/say")
    String sayHello();
}
