package com.ynov.microservices;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import com.ynov.microservices.oo.Point;
import static java.lang.Math.*;


@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
@EnableHystrixDashboard
public class SpringHystrixDashboardApplication {

	public static void main(String[] args) {
		Point p = new Point();
		p.setZ("toto");
		Point i = new Point();
		//System.out.println(i.getZ());
		Point.setZ("toto");
		ArrayList<Integer> test = new ArrayList<>();
		//test.forEach(System.out::println);	
		min(1, 2);
		boolean containsZero = test.stream().anyMatch(item -> item.equals(0));
		boolean allZero = test.stream().allMatch(item -> item.equals(0));
		D a = new D();
		a.foo();
		a.bar();
		//SpringApplication.run(SpringHystrixDashboardApplication.class, args);
	}

}
