package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    RouteLocator gateway(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("policy_route", r -> r
                        .path("/client/**")
                        //.filters(f -> f.stripPrefix(1))
                        .uri("lb://CLIENTAPP-SUNLIFE"))

                .build();
    }
}