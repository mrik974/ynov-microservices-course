package com.ynov.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringPetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPetServiceApplication.class, args);
	}

}
