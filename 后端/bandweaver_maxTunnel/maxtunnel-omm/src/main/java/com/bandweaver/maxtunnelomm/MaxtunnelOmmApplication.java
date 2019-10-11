package com.bandweaver.maxtunnelomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.bandweaver.maxtunnelomm","com.bandweaver.maxtunnelfeign"})
@EnableEurekaClient
@EnableFeignClients(value={"com.bandweaver.maxtunnelfeign"})
public class MaxtunnelOmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelOmmApplication.class, args);
	}

}
