package com.example.communication.restTemplate.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// URL 클래스
// 웹상의 주소를 나타내는 클래스고 이를 통해서 식별하거나 네트워크 연결도 가능하다.
// 웹상의 리소스를 가져올 수 있다.
public class URLTest01 {
    public static void main(String[] args) {
        try {
            URI url = new URI("https://www.naver.com");
            System.out.println("url.toString() = " + url.toString());
            System.out.println("url.getPort() = " + url.getPort());
            // -1 포트로 접속했다는 의미가 아니라 프로토콜에 등록된 기본 port로 접속했다는 의미
            // http 프로토콜은 기본 port 80이고 우리가 접속하는 url은 80포트
            System.out.println("url.getPath() = " + url.getPath());
            // 인터넷  상의 자원을 읽어보기
            BufferedReader br = new BufferedReader(new InputStreamReader(url.toURL().openStream()));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println("line = " + line);
                System.out.println();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
