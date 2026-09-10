package com.example.sunlife_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SunlifeRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunlifeRegistryApplication.class, args);
	}

}
