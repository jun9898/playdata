package com.example.gatewayexamserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayFilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec
                        -> predicateSpec.path("/jbm/**")
                        .filters(gatewayFilterSpec ->
                                gatewayFilterSpec.addRequestHeader("examreq", "출력되면 결과 캡쳐해서 보내주세여 jbm")
                                        .addRequestHeader("examres", "출력되면 결과 캡쳐해서 보내주세여 jbm"))
                        .uri("http://192.168.0.3:9992/")
                )
                .route(predicateSpec
                        -> predicateSpec.path("/leh/**")
                        .filters(gatewayFilterSpec ->
                                gatewayFilterSpec.addRequestHeader("examreq", "출력되면 결과 캡쳐해서 보내주세여 leh")
                                        .addRequestHeader("examres", "출력되면 결과 캡쳐해서 보내주세여 leh"))
                        .uri("http://192.168.0.147:9585/")
                )
                .route(predicateSpec
                        -> predicateSpec.path("/hyunji/**")
                        .filters(gatewayFilterSpec ->
                                gatewayFilterSpec.addRequestHeader("examreq", "출력되면 결과 캡쳐해서 보내주세여 h")
                                        .addRequestHeader("examres", "출력되면 결과 캡쳐해서 보내주세여 h"))
                        .uri("http://192.168.0.12:9028/")
                )
                .route(predicateSpec
                        -> predicateSpec.path("/jbj/**")
                        .filters(gatewayFilterSpec ->
                                gatewayFilterSpec.addRequestHeader("examreq", "응애"))
                        .uri("http://192.168.0.16:9400/")
                )
                .build();
    }
}
