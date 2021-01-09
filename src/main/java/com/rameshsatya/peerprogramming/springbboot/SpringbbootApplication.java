package com.rameshsatya.peerprogramming.springbboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rameshsatya.peerprogramming.springbboot")
public class SpringbbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbbootApplication.class, args);
	}

}
