package com.ynov.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class SpringOwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOwnerServiceApplication.class, args);
	}

}
