package com.example.clientapp_sunlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class ClientappSunlifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientappSunlifeApplication.class, args);
	}

}
