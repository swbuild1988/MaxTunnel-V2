package com.bandweaver.maxtunnelfeign.shiro.fallback;

import com.bandweaver.maxtunnelfeign.shiro.RemoteRabbitMqService;
import com.bandweaver.maxtunnelfeign.vo.R;
import org.springframework.stereotype.Component;

@Component
public class RemoteRabbitMqServiceFallback implements RemoteRabbitMqService {

    @Override
    public R deleteQueue(String kequeueNamey) {
        return new R(500, "false");
    }
}
