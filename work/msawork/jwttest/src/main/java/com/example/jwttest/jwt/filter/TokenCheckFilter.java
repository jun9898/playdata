package com.example.jwttest.jwt.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TokenCheckFilter extends BasicAuthenticationFilter {

    public TokenCheckFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("======================================= 요청할때 실행되는 필터 ==========================================");
        // 1. 토큰을 꺼내서 해당 사용자가 맞는지 확인 - 서명확인 (시크릿키를 가지고 파싱)
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info(authorization);
        // => 확인 완료후 사용자가 맞으면 토큰에서 꺼낸 pk로 조회하는 작업 시행
        //                                   ----------------
        //                          사용자 정보를 조회해서 SecurityContext에 공유
        // 2. 해당 사용자가 아니면 접근할 수 없도록 처리
        super.doFilterInternal(request, response, chain);
    }
}