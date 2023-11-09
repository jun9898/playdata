package com.example.jwttest.jwt.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyTestFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("===========================PRE MyTestFilter2==========================");
        chain.doFilter(request, response);
        log.info("===========================POST MyTestFilter2==========================");
    }
}
