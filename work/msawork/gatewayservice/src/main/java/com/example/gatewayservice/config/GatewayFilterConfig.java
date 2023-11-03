package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayFilterConfig {
    // RouteLocatorBuilder를 이욯해서 route 정보와 filter정보를 담고 있는
    // RouteLocator 객체를 만들어서 리턴하도록 작업 @Bean으로 등록해야
    // 스프링이 관리하는 객체가 된다. 그냥 생성만 하면 스프링이 인식하지 못함
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec
                        -> predicateSpec.path("/first/**")
                                .filters(gatewayFilterSpec ->
                                        // 필터에 대한 정보
                                        gatewayFilterSpec.addRequestHeader("firstreq","firstrequest")
                                                         .addResponseHeader("firstres", "firstrequest"))
                        .uri("http://127.0.0.1:9100/"))
                .route(predicateSpec
                        -> predicateSpec.path("/second/**")
                        .filters(gatewayFilterSpec ->
                                // 필터에 대한 정보
                                gatewayFilterSpec.addRequestHeader("secondreq","secondrequest")
                                        .addResponseHeader("secondres", "secondrequest"))
                        .uri("http://127.0.0.1:9200/"))
                .route(predicateSpec
                        -> predicateSpec.path("/third/**")
                        .filters(gatewayFilterSpec ->
                                // 필터에 대한 정보
                                gatewayFilterSpec.addRequestHeader("thirdreq","thirdrequest")
                                        .addResponseHeader("thirdres", "thirdrequest"))
                        .uri("http://127.0.0.1:9300/"))
                .build();
    }
}
