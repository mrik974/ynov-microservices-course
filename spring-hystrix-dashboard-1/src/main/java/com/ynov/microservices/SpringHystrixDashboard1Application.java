package com.ynov.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHystrixDashboard1Application {

	public static void main(String[] args) {
		Point p = new Point();
		SpringApplication.run(SpringHystrixDashboard1Application.class, args);
	}

}
