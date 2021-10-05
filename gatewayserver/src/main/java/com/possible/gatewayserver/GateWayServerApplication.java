package com.possible.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class GateWayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayServerApplication.class, args);
    }

//    dynamic routing
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeBuilder){
        return routeBuilder.routes()
                .route(predicateSpec -> predicateSpec.path("/e-banking/accounts/**")
                        .filters(f -> f.rewritePath("/e-banking/accounts/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                                .uri("lb://accounts") )

                .route(p -> p.path("/e-banking/loans/**")
                        .filters(f -> f.rewritePath("/e-banking/loans/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://loans") )

                .route(p -> p.path("/e-banking/cards/**")
                        .filters(f -> f.rewritePath("/e-banking/cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://cards") )
                .build();
    }

}
