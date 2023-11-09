package com.example.jwttest.jwt.filter;

import org.apache.tomcat.util.http.parser.Authorization;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestTestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");
        System.out.println("authorzation = " + authorization);
        //이 메소드가 호출되이 않으면 다음으로 넘어가지 않음
        chain.doFilter(request, response);

    }
}
