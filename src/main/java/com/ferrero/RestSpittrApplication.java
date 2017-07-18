package com.ferrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ferrero"})
public class RestSpittrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSpittrApplication.class, args);
	}
}
