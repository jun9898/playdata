package com.example.gatewayservice.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OrderTestFilter extends AbstractGatewayFilterFactory<OrderTestFilter.Config> {
    public OrderTestFilter() {
        super(Config.class);
    }

    @Data
    public static class Config{

    }
    @Override
    public GatewayFilter apply(Config config){
        GatewayFilter filter =
                new OrderedGatewayFilter((exchange, chain) -> {
                    System.out.println("==============ordertest pre 필터================");
                    return chain.filter((exchange)).then(Mono.fromRunnable(()-> {
                        System.out.println("==============ordertest post 필터================");
                    }));
                }, Ordered.LOWEST_PRECEDENCE); //우선순위 상수
        return filter;
    }
}
