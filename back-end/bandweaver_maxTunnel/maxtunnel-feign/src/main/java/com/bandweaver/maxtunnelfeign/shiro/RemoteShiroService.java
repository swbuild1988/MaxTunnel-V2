package com.bandweaver.maxtunnelfeign.shiro;

import com.bandweaver.maxtunnelfeign.constants.ServiceNameConstant;
import com.bandweaver.maxtunnelfeign.shiro.fallback.RemoteShiroServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(value = ServiceNameConstant.AUTH_SERVICE,
        path = "/shiro", fallback = RemoteShiroServiceFallback.class)
public interface RemoteShiroService {

    @RequestMapping("/permissions")
    Set<String> getAuthorityByUser(String name);

    @GetMapping("/redis")
    String getRedis(@RequestParam("key") String key);

    @RequestMapping("/say")
    String sayHello();
}
