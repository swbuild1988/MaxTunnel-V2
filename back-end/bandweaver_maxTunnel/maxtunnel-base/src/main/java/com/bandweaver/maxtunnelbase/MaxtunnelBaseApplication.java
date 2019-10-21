package com.bandweaver.maxtunnelbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.bandweaver.maxtunnelbase","com.bandweaver.maxtunnelfeign"})
@EnableFeignClients(value={"com.bandweaver.maxtunnelfeign"})
public class MaxtunnelBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelBaseApplication.class, args);
	}

}
