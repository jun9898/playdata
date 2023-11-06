package com.example.gatewayservice.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

// 가장 상위 개념인 Componet로 설정해준다
@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    public GlobalFilter() {
        super(Config.class);
    }

    @Data
    public static class Config{
        private String message;
        private boolean check;
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            HttpHeaders headers = request.getHeaders();
            System.out.println("=======================글로벌 Pre필터 ==========================");
            System.out.println("설정값 ============== " + config.message);
            System.out.println("설정값 ============== " + config.check);

                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    System.out.println("=======================글로벌 Post필터 ==========================");
                }
            ));
        };
    }

}
