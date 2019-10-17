package com.bandweaver.maxtunnelshiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.bandweaver")
public class MaxtunnelShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelShiroApplication.class, args);
	}

}
