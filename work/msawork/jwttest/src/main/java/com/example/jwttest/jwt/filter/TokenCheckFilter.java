package com.example.jwttest.jwt.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwttest.jwt.dao.SampleRepository;
import com.example.jwttest.jwt.model.CustomerUserDetail;
import com.example.jwttest.jwt.model.SampleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TokenCheckFilter extends BasicAuthenticationFilter {

    private final SampleRepository repository;

    public TokenCheckFilter(AuthenticationManager authenticationManager, SampleRepository repository) {
        super(authenticationManager);
        this.repository = repository;
    }

    public TokenCheckFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint, SampleRepository repository) {
        super(authenticationManager, authenticationEntryPoint);
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("======================================= 요청할때 실행되는 필터 ==========================================");
        // 1. 토큰을 꺼내서 해당 사용자가 맞는지 확인 - 서명확인 (시크릿키를 가지고 파싱)
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("autorization =>{}", authorization);
        // => 확인 완료후 사용자가 맞으면 토큰에서 꺼낸 pk로 조회하는 작업 시행
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            chain.doFilter(request,response);
            return;
        }
        // JWT 토큰을 검증해서 정상 사용자인지 확인 = JWT 토큰을 파싱해서 같은 인증 토큰인지 확인
        String token = request.getHeader(HttpHeaders.AUTHORIZATION)
                .replace("Bearer ", "");
        String username = JWT.require(Algorithm.HMAC256("key")).build()
                                .verify(token)
                                .getClaim("username")
                                .asString();
        log.info("토큰에서 꺼낸 username =>{}", username);
        // 수정해야 하는 부분 => 빠르게 테스트하기 위해서 작업
        // 인증된 사용자면 사용자 정보를 가져오거나 필요한 작업을 수행
        if (username != null) {
            SampleEntity entity = repository.findByUsername(username);
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // user 권한설정
            CustomerUserDetail userDetail = new CustomerUserDetail(entity, roles);
            // 시큐리티 내부에서 사용한 인증토큰 (UsernamePasswordAuthenticationToken) 에 유저정보를 저장
            Authentication securityToken = new UsernamePasswordAuthenticationToken(userDetail, null, roles);
            // 시큐리티 내부에서 사용되는 public 저장소
            SecurityContextHolder.getContext().setAuthentication(securityToken);
            log.info("Security Authentication Token => {}", securityToken);
        }
        chain.doFilter(request, response);
    }
}