package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", route -> route
                        .path("/api/product/**")
                        .uri("lb://product-service"))
                .route("order-service", route -> route
                        .path("/api/order/**")
                        .uri("lb://order-service"))
                .build();
    }
}
