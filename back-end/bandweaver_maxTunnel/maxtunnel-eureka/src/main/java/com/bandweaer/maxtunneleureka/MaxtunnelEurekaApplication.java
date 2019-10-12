package com.bandweaer.maxtunneleureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MaxtunnelEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelEurekaApplication.class, args);
	}

}
