package com.bandweaver.maxtunnelshiro.configuration;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FanoutRabbitConfig {

    @Value("${bandweaver.rabbitmq.host}")
    String host;
    @Value("${bandweaver.rabbitmq.port}")
    Integer port;
    @Value("${bandweaver.rabbitmq.username}")
    String username;
    @Value("${bandweaver.rabbitmq.password}")
    String password;
    @Value("${bandweaver.rabbitmq.exchangeName}")
    String exchangeName;


    //创建mq连接
    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        //connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    //创建channel
    @Bean(name = "channel")
    public Channel getChannel()  {
        Connection connection = this.connectionFactory().createConnection();
        Channel channel = connection.createChannel(false);
        try {
            channel.exchangeDeclare(exchangeName,"fanout");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return channel;
    }


}
