package com.example.redisjwt.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
//빈이 생성되고 주입을 받은 후에
public class TokenProvider implements InitializingBean {
    private final String secret;
    private final long tokenSecond;
    private Key key;
    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.token-validity-in-second}") long tokenSecond){
        this.secret = secret;
        this.tokenSecond = tokenSecond;
    }

    //secret값을 base64 decode해서 key변수에 할당
    @Override
    public void afterPropertiesSet() throws Exception{
        byte[] keydata = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keydata);
    }

    public String createToken(Authentication authentication) {
        // 인증이 완료된 후 인증 객체에 저장되어 있는 권한 정보를 꺼내서 하나의 문자열을 만들기
        String authorityList = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        // 토큰 만료시간
        long nowtime = new Date().getTime(); //현재시간을 Long으로 반환
        // 토큰이 생성된 시간을 기점으로 만료 시간을 설정
        Date targetTime = new Date(nowtime + this.tokenSecond);
        // 토큰만들어서 리턴
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth", authorityList) // 권한정보
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(targetTime)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // 클래임 객체에서 권한정보를 추출하기
        List<SimpleGrantedAuthority> authorityList = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
        // 권한객체 이용해서 최종적으로 Authentication 객체를 만들어서 작업하기
        // Authentication 객체에 저장할 스프링 시큐리티의 내부에서 인식하는 User객체 생성
        User principal = new User(claims.getSubject(), "", authorityList);
        return new UsernamePasswordAuthenticationToken(principal, token, authorityList);
    }

    // 토큰을 validator할 수 있는 메소드
    // 토큰의 유효성을 검증
    // io.jsonwebtoken 라이브러리 내부에서 제공하는 Exception 객체를 활용
    public boolean validatorToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true; // 토큰 파싱이 정상처리 -> 문제없는 토큰
        } catch (SecurityException | MalformedJwtException e) { // - 문제가 있는 토큰
            System.out.println("잘못된 형식으로 서명된 토큰");
        } catch (ExpiredJwtException e) {
            System.out.println("만료된 토큰");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 토큰");
        }
        return false;
    }

}