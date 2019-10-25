package com.bandweaver.maxtunnelfeign.shiro.fallback;

import com.bandweaver.maxtunnelfeign.shiro.RemoteShiroService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RemoteShiroServiceFallback implements RemoteShiroService {

    @Override
    public Set<String> getAuthorityByUser(String name) {
        Set<String> result = new HashSet<String>();
        result.add("list 服务降级,my god !!!");
        return result;
    }

    @Override
    public String getRedis(String key) {
        String result = "降级处理 获取shiro redis 失败";
        return result;
    }

    @Override
    public String sayHello() {
        String result = "降级处理 say no !!!";
        return result;
    }
}
