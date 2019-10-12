package com.bandweaver.maxtunnelgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.bandweaver.maxtunnelgateway","com.bandweaver.maxtunnelfeign"})
@EnableFeignClients(value={"com.bandweaver.maxtunnelfeign"})
public class MaxtunnelGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelGatewayApplication.class, args);
	}

}
