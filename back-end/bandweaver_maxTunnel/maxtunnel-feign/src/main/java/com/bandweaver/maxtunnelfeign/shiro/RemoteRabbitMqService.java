package com.bandweaver.maxtunnelfeign.shiro;

import com.bandweaver.maxtunnelfeign.constants.ServiceNameConstant;
import com.bandweaver.maxtunnelfeign.shiro.fallback.RemoteRabbitMqServiceFallback;
import com.bandweaver.maxtunnelfeign.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ServiceNameConstant.AUTH_SERVICE,
        path = "/rabbit", fallback = RemoteRabbitMqServiceFallback.class)
public interface RemoteRabbitMqService {

    @GetMapping("/deleteQueue")
    R deleteQueue(@RequestParam("queueName") String kequeueNamey);

}
