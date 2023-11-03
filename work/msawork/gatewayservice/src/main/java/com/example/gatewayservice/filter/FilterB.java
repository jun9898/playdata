package com.example.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class FilterB extends AbstractGatewayFilterFactory<FilterB.Config> {

    public FilterB() {
        super(Config.class);
    }

    public static class Config{
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("필터 B pre 필터 수행");
            ServerHttpRequest request = exchange.getRequest();
            HttpHeaders headers = request.getHeaders();
            String mydata = headers.getFirst("data");
            System.out.println("mydata = " + mydata);
            if (mydata.equals("mydata")){
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    System.out.println("필터 B post 필터 수행");
                }));
            } else {
                System.out.println("필터 B post 필터 안수행");
                return chain.filter(exchange);
            }
        };
    }
}

