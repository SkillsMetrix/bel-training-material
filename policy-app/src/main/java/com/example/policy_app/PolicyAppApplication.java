package com.example.policy_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.insurance")
public class PolicyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyAppApplication.class, args);
	}

}
