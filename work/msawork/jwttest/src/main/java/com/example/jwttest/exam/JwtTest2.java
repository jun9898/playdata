package com.example.jwttest.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

// auth0: java-jwt 라이브러리
public class JwtTest2 {
    public static void main(String[] args) {
        // JWT - create
        // JWT 스펙에서 정의한 claim을 추가할 수 있다
        /*
        * iss : 토큰을 발행한 단체나 사이트가 누구인지
        * sub(Subject) : 어떤 주제에 대한 토큰인지
        * lat : 토큰을 발행한 시간
        * jti : 토큰 일련 번호
        * exp : 토큰의 만료 시간
        */
        String oauth_token = JWT.create()
                .withClaim("name","jbj")
                .withClaim("id","jun98")
                .sign(Algorithm.HMAC256("testkey"));

        System.out.println("oauth_token = " + oauth_token);

        JwtTest1.printToken(oauth_token);

        // 파싱또한 당연히 가능하다
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("testkey")).build();
        DecodedJWT verify = verifier.verify(oauth_token);
        System.out.println("verify.getClaim() = " + verify.getClaims());
    }
}
