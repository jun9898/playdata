package com.example.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// 가장 상위 개념인 Componet로 설정해준다
@Component
public class MyFilter extends AbstractGatewayFilterFactory<MyFilter.Config> {
    public MyFilter() {
        super(Config.class);
    }

//    설정 내용을 정의하거나 변경하려면 적용할 수 있도록 내부에 설정정보를 정의한 inner 클래스를 정의
    public static class Config{

    }
//    필터를 통해서 구현하고 싶은 기능을 정의하는 메소드
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
                // GatewayFilterChain 객체의 filter() 메소드가 호출되기 전에 정의된 내용이 pre Filter
                // 요청이 서비스로 가기 전에 실행할 내용
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();
                HttpHeaders headers = request.getHeaders();

                System.out.println("headers.containsKey(\"firstreq\") = " + headers.containsKey("firstreq"));

                // post필터 작업하는 곳
                // Mono 객체는 비동기 방식으로 필터를 정의할때 단일값을 전달하기 위해서 만들어짐
                // exchange는 또 다른 필터가 정의되어 있는 경우 다른 필터가 정상실행 되도록 처리할때 사용
//                chain.filter()
                // fromRunnable 로 만드는 Mono 객체는 비동기 방식으로 필터를 정의할때 단일값을 전달하기 위해서 만들어짐
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                        System.out.println("사용자정의 post필터" + response.getStatusCode());
                }
            ));
        };
    }
//    public GatewayFilter apply(Config config) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                // GatewayFilterChain 객체의 filter() 메소드가 호출되기 전에 정의된 내용이 pre Filter
//                // 요청이 서비스로 가기 전에 실행할 내용
//                ServerHttpRequest request = exchange.getRequest();
//                ServerHttpResponse response = exchange.getResponse();
//                HttpHeaders headers = request.getHeaders();
//
//                System.out.println("headers.containsKey(\"firstreq\") = " + headers.containsKey("firstreq"));
//
//                // post필터 작업하는 곳
//                // Mono 객체는 비동기 방식으로 필터를 정의할때 단일값을 전달하기 위해서 만들어짐
//                // exchange는 또 다른 필터가 정의되어 있는 경우 다른 필터가 정상실행 되도록 처리할때 사용
////                chain.filter()
//                // fromRunnable 로 만드는 Mono 객체는 비동기 방식으로 필터를 정의할때 단일값을 전달하기 위해서 만들어짐
//                return chain.filter(exchange).then(Mono.fromRunnable(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("사용자정의 post필터" + response.getStatusCode());
//                    }
//                }));
//            }
//        };
//    }

}
