package com.example.jwttest.jwt.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class MyTestFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if ("POST".equalsIgnoreCase(servletRequest.getMethod())) {
            log.info("===========================PRE MyTestFilter3==========================");
            String token = servletRequest.getHeader("Authorization");
            if (token != null) {
                chain.doFilter(request, response);
                log.info("===========================POST MyTestFilter3==========================");
            } else {
                log.info("===========================토큰없당==========================");
            }
        } else {
            log.info("===========================POST 요청하세용==========================");
        }
    }
}
