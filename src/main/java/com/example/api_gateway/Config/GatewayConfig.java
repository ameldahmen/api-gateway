package com.example.api_gateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/auth/**")
                        .uri("http://localhost:8081")) // Route to auth-service
                .route("product-service", r -> r.path("/api/products/**")
                        .uri("lb://product-service")) // Route to product-service
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("lb://user-service")) // Route to user-service
                .build();
    }
}