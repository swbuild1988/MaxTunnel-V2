package com.bandweaver.maxtunnelcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.bandweaver.maxtunnelcommon","com.bandweaver.maxtunnelfeign"})
@EnableFeignClients(value={"com.bandweaver.maxtunnelfeign"})
public class MaxtunnelCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaxtunnelCommonApplication.class, args);
    }


}
