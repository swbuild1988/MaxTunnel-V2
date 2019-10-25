package com.bandweaver.maxtunneleureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Slf4j
@Component
public class EurekaStateChangeListener {

    @Autowired
    private JavaMailSenderImpl jms;

    /**
     * 监控注册中心 服务下线事件
     *    当有注册的服务下线的时候会自动触发
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStamp = event.getTimestamp();
        String time = simpleDateFormat.format(timeStamp);
        log.info("服务{}已下线", event.getAppName());
        log.info("服务下线时间{}", time);
        log.info("server地址信息{}", event.getServerId());
        log.info("server.getSource{}", event.getSource());

        String msg = "Eureka服务下线通知:服务{"+event.getAppName()
                +"}已下线,下线时间-"+ time
                +",server地址信息-" +event.getServerId();
        System.out.println(msg);
       // this.send(msg);
    }

    public void send(String msg){
        //用于封装邮件信息的实例
        SimpleMailMessage smm=new SimpleMailMessage();
        //由谁来发送邮件
        smm.setFrom("lutao.lv@bandweaver.cn");
        //邮件主题
        smm.setSubject("Eureka服务下线");
        //邮件内容
        smm.setText(msg);
        //接受邮件
        String[] mailtoArr = {"lutao.lv@bandweaver.cn","wei.shan@bandweaver.cn","ya.liu@bandweaver.cn","huijun.gong@bandweaver.cn"};
        smm.setTo(new String[]{"lutao.lv@bandweaver.cn","ya.liu@bandweaver.cn"});
        try {
            jms.send(smm);
        } catch (Exception e) {
            log.info(msg+"错误",e);
        }
    }


}
