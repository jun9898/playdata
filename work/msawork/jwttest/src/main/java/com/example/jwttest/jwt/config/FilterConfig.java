package com.example.jwttest.jwt.config;

import com.example.jwttest.jwt.filter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class FilterConfig {

/*
    @Bean
    public FilterRegistrationBean<MyTestFilter1> makefilter1() {
        FilterRegistrationBean<MyTestFilter1> filter1 = new FilterRegistrationBean<>(new MyTestFilter1());
        filter1.addUrlPatterns("/*"); //이러한 url요청에 필터 1을 실행
        filter1.setOrder(0); //숫자가 작은 순서대로 적용

        return filter1;
    }
    @Bean
    public FilterRegistrationBean<MyTestFilter2> makefilter2() {
        FilterRegistrationBean<MyTestFilter2> filter2 = new FilterRegistrationBean<>(new MyTestFilter2());
        filter2.addUrlPatterns("/*"); //이러한 url요청에 필터 1을 실행
        filter2.setOrder(2); //숫자가 작은 순서대로 적용

        return filter2;
    }
    @Bean
    public FilterRegistrationBean<MyTestFilter3> makefilter3() {
        FilterRegistrationBean<MyTestFilter3> filter3 = new FilterRegistrationBean<>(new MyTestFilter3());
        filter3.addUrlPatterns("/*"); //이러한 url요청에 필터 1을 실행
        filter3.setOrder(1); //숫자가 작은 순서대로 적용

        return filter3;
    }
*/

/*
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> myfilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> filter = new FilterRegistrationBean<>(new JwtAuthenticationFilter());
        filter.addUrlPatterns("/*"); //이러한 url요청에 필터 1을 실행
        filter.setOrder(1); //숫자가 작은 순서대로 적용
        return filter;
    }
*/

/*
    @Bean
    public FilterRegistrationBean<RequestTestFilter> makefilter4() {
        FilterRegistrationBean<RequestTestFilter> filter4 = new FilterRegistrationBean<>(new RequestTestFilter());
        filter4.addUrlPatterns("/*"); //이러한 url요청에 필터 1을 실행
        filter4.setOrder(3); //숫자가 작은 순서대로 적용

        return filter4;
    }
*/

    @Bean
    public CorsFilter corsFilter() {
        //허용할 수 있는 부분을 정의
        //UrlBasedCorsConfigurationSource에 허용 범위에 포함된 내용을 정의하고
        //정의한 자원의 허용범위값을 config에 셋팅
        //config를 어떤 요청 범위에 대해서 설정할것인지 UrlBasedCorsConfigurationSource에 설정
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //json서버 응답을 사바 스크립트에서 처리할 수 있도록 허용
        //크로스 도메인에서 요청을 주고 받을때 쿠키에 대한 처리, Authorization이 있는 요청 모두 허용
        //클라이언트에서도 처리
        config.setAllowCredentials(true);
        //버전이 달라지면서 사용메소드가 변경
//        config.addAllowedOrigin("*"); //모든 ip에 대해서 응답을 허용
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*"); //모든 http method를 허용
        config.addAllowedHeader("*"); //모든 http header를 허용
        // 외부에서 헤더값을 읽기 위한 설정
        config.addExposedHeader("Authorization");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);

    }
}
