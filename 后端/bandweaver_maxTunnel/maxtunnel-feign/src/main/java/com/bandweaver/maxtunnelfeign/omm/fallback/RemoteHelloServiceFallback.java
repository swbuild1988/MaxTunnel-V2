package com.bandweaver.maxtunnelfeign.omm.fallback;

import com.bandweaver.maxtunnelfeign.omm.RemoteHelloService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteHelloServiceFallback implements RemoteHelloService {

    @Override
    public List<String> getUserList() {
        List<String> result = new ArrayList<>();
        result.add("list 服务降级,my god !!!");
        return result;
    }

    @Override
    public String sayHello() {
        return "omm 服务降级,my god !!!";
    }
}
