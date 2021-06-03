package com.india.icicibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IcicibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcicibankApplication.class, args);
	}

}
