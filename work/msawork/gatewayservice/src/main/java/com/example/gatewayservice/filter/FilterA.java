package com.example.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
public class FilterA extends AbstractGatewayFilterFactory<FilterA.Config> {

    public FilterA() {
        super(Config.class);
    }

    public static class Config{
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("필터 A pre 필터 수행");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                        System.out.println("필터 A post 필터 수행");
                    }
            ));
        };
    }
}

