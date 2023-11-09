package com.example.jwttest.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

public class JwtTest3 {
    public static void main(String[] args) {

        // 시크릿키를 특정 함수를 적용해서 값을 변경하기(해싱)
        byte[] SEC_KEY = DatatypeConverter.parseBase64Binary("testkey");
        // auth 라이브러리로 토큰 생성
        String auth_token = JWT.create()
                .withClaim("name","jbj")
                .withClaim("id","jun98")
                .sign(Algorithm.HMAC256(SEC_KEY));

        // auth 라이브러리로 파싱
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SEC_KEY)).build();
        DecodedJWT verify = verifier.verify(auth_token);
        System.out.println("verify.getClaim() = " + verify.getClaims());


        // okta 라이브러리로 파싱 - 시크릿키를 한번 더 해싱해서 작업
        Jws<Claims> testkey = Jwts.parser().setSigningKey("testkey")
                .parseClaimsJws(auth_token);
        System.out.println("testkey = " + testkey);

    }
}
