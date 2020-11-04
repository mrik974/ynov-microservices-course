package com.ynov.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringVisitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVisitServiceApplication.class, args);
	}

}
