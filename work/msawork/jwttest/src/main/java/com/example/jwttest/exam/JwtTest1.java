package com.example.jwttest.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.*;

import java.util.Base64;
import java.util.Map;

// okta의 토큰 만들기
public class JwtTest1 {
    public static void printToken(String token) {
        String[] splitdata = token.split("\\.");
        System.out.println("header : " + new String(Base64.getDecoder().decode(splitdata[0])) );
        System.out.println("payload : " + new String(Base64.getDecoder().decode(splitdata[1])) );
    }
    public static void main(String[] args) {
        // jjwt를 이용한 토큰 사용
        // jwts가 빌더패턴이 적용된 객체 - 토근을 만들때 사용하는 빌더
        String okta_jwt_token = Jwts.builder()
                .addClaims(Map.of("name", "jbj","id","jun98"))
                // 서명
                .signWith(SignatureAlgorithm.HS256, "testkey")
                .compact(); // 위의 정보를 이용해서 토큰을 생성
        System.out.println("okta_jwt_token = " + okta_jwt_token);
        printToken(okta_jwt_token);

        // 토큰을 파싱하기
        Jws<Claims> testkey = Jwts.parser().setSigningKey("testkey")
                .parseClaimsJws(okta_jwt_token);

        System.out.println("testkey = " + testkey);

/*
        String oauth_token = JWT.create()
                .withClaim("name","jbj")
                .withClaim("id","jun98")
                .sign(Algorithm.HMAC256("testkey"));
*/

/*
        사용하는 토큰의 종류가 다르면 파싱이 안된다
        Jws<Claims> oauth_token_test = Jwts.parser().setSigningKey("testkey")
                .parseClaimsJws(oauth_token);
        System.out.println("oauth_token_test = " + oauth_token_test);
*/


    }
}

