package com.bandweaver.maxtunnelshiro.controller;

import com.bandweaver.maxtunnelcommon.utils.R;
import com.bandweaver.maxtunnelshiro.configuration.RedisUtil;
import com.bandweaver.maxtunnelshiro.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 删除队列
     * @param queueName
     */
    @GetMapping("deleteQueue")
    public R deleteQueue(@RequestParam("queueName") String queueName){
        rabbitMqService.deleteQueue(queueName);
        log.info("--- 删除队列{}成功 ---" , queueName);
        return new R(200,"success");
    }

}
