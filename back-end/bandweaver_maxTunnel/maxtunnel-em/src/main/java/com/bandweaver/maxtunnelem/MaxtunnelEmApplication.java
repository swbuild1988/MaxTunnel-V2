package com.bandweaver.maxtunnelem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.bandweaver.maxtunnelem","com.bandweaver.maxtunnelfeign","com.bandweaver.maxtunnelcommon"})
@EnableFeignClients(value={"com.bandweaver.maxtunnelfeign"})
public class MaxtunnelEmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxtunnelEmApplication.class, args);
	}

}
