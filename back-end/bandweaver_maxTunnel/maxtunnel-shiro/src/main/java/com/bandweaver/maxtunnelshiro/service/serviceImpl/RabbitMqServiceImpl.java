package com.bandweaver.maxtunnelshiro.service.serviceImpl;

import com.bandweaver.maxtunnelshiro.configuration.FanoutRabbitConfig;
import com.bandweaver.maxtunnelshiro.entity.SecurityUser;
import com.bandweaver.maxtunnelshiro.service.RabbitMqService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Value("${bandweaver.rabbitmq.exchangeName}")
    String exchangeName;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private FanoutRabbitConfig fanoutRabbitConfig;

    @Override
    public String createQueue() {
        try {
            Channel channel = fanoutRabbitConfig.getChannel();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            SecurityUser user = (SecurityUser) session.getAttribute("userInfo");
            //生成队列名   userName-yyyyMMddHHmmss
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(new Date());
            String queueName = user.getName() + "-" + date;
            boolean durable = true;
            boolean exclusive = false;
            boolean auto_delete = false;
            channel.queueDeclare(queueName, durable, exclusive, auto_delete, null);
            channel.queueBind(queueName, exchangeName, "");
            return queueName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteQueue(String queueName) {
        try {
            Channel channel = fanoutRabbitConfig.getChannel();
            if(StringUtils.isNotBlank(queueName)){
                channel.queueDelete(queueName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String message) {
        try {
            Channel channel = fanoutRabbitConfig.getChannel();
            channel.basicPublish(exchangeName, "", null, message.getBytes("UTF-8"));
            log.info("发送消息：" + message);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    /**
     * 发送消息，带上类型
     *
     * @param type
     * @param message
     */
    @Override
    public void sendByType(String type, String message) {
        JSONObject object = new JSONObject();
        object.put("type", type);
        object.put("content", message);
        send(object.toJSONString());
    }


}
