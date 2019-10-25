package com.bandweaver.maxtunnelshiro.service;

public interface RabbitMqService {


    //创建队列
    String createQueue();

    //删除队列
    void deleteQueue(String queueName);

    void send(String message);

    /**
     * 发送消息，带上类型
     * @param type
     * @param message
     */
    void sendByType(String type, String message);


}
