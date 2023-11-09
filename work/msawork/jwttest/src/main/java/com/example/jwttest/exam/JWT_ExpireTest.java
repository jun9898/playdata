package com.example.jwttest.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwt;

import java.util.Date;

public class JWT_ExpireTest {
    public static void main(String[] args) throws InterruptedException {
        Algorithm algorithm = Algorithm.HMAC256("key");

        //JWT생성
        String token = JWT.create()
                .withSubject("bts")
                //최소 1초는 있어야 실행하겠다는 의미
                .withNotBefore(new Date(System.currentTimeMillis()+1000))
                //토큰만료시간
                .withExpiresAt(new Date(System.currentTimeMillis()+3000))
                .sign(algorithm);

        //시간지연 - 만료시간을 넘기기
        //Thread.sleep(5000);

        try {
            DecodedJWT vDecodedJWT = JWT.require(algorithm).build().verify(token);
            System.out.println(vDecodedJWT.getClaims());
        }catch (Exception e){
            System.out.println("유효하지 않은 토큰");
            //유효하지 않은 토큰이라고 하더라도 경우에 따라서 어떤 사용자가 요청한 것인지
            //정보를 봐야 하는 경우가 있다.
            DecodedJWT decodedJWT = JWT.decode(token);
            System.out.println(decodedJWT.getClaims());
        }
    }
}