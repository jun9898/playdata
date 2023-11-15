package com.example.communication.restTemplate.service;
// 서비스를 제공하는 컨트롤러

import com.example.communication.restTemplate.dto.UserInfoRequest;
import com.example.communication.restTemplate.dto.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// RestTemplateAPI로 동기통신을 요청하기 위한 서비스
// RestTemplate 사용방법
//=> 동기 방식으로 요청을 보내고 응답을 받을때까지 블로킹 된다
//블로킹 - 요청을 보내고 응답이 완료되기 전까지 다음 코드를 실행하지 않는다. 응답을 기다리는 동안 대기
@Service
@Slf4j
public class RestTemplateService {
    // http://127.0.0.1:3100/api/server/first 에 접속해서 response를 받아오기
    public String first() {
        // 1. 주소 만들기 - URI 객체를 만들어야 한다.
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/first")
                .encode()
                .build()
                .toUri();
        log.info("빌드된 주소 ======== {}", uri);
        RestTemplate restTemplate = new RestTemplate();
        // 매개변수로 전달한 URI 객체에 설정된 주소로 연결하고 결과로 response를 받아온다
        // getForObject 가 실행되는 시점이 클라이언트에서 서버로 연결하는 시점이라 생각하면 된다.
        // http get방식으로 통신하는 경우
        // getForObject는 지정한 response타입으로 객체를 바로 받아와서 사용할 수 있다.
        // -> Response객체에 대한 다른 속성을 사용할 수 없다.
        String resultObj = restTemplate.getForObject(uri, String.class);
        log.info("통신 후 응답된 데이터 ==========> {}", resultObj);

        // 바로 응답 데이터로 return하지 않고 ResponseEntity로 응답하므로 응답된 데이터를 알맞게 꺼내서 사용
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        log.info("응답된 데이터의 상태코드 ==========> {}", forEntity.getStatusCode());
        log.info("응답된 데이터의 헤더 ==========> {}", forEntity.getHeaders());
        log.info("응답된 데이터의 바디 ==========> {}", forEntity.getBody());
        return forEntity.getBody();
    }

    public UserInfoResponse getdata() {
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/getdata")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserInfoResponse> forEntity = restTemplate.getForEntity(uri, UserInfoResponse.class);
        log.info("응답된 데이터의 바디 =====> {}" , forEntity.getBody());
        return forEntity.getBody();
    }

    public UserInfoResponse paramtest() {
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/paramtest")
                .queryParam("username", "jbj")
                .queryParam("password", "jbj")
                .queryParam("name", "전병준")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserInfoResponse> forEntity = restTemplate.getForEntity(uri, UserInfoResponse.class);
        log.info("빌드된 주소 ======== {}", uri);
        log.info("응답된 데이터의 바디 (ParamTest) =====> {}" , forEntity.getBody());
        return forEntity.getBody();
    }

    public String pathvariabletest() {
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/board/{username}/{id}")
                .encode()
                .build()
                .expand("junUsername",10)
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        log.info("빌드된 주소 ======== {}", uri);
        log.info("응답된 데이터의 바디 (pathvariabletest) =====> {}" , forEntity.getBody());
        return forEntity.getBody();
    }

    public UserInfoResponse posttest() {
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/create")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        UserInfoRequest request = new UserInfoRequest("jun", "1234", "전병준");
        ResponseEntity<UserInfoResponse> forEntity = restTemplate.postForEntity(uri, request, UserInfoResponse.class);
        log.info("빌드된 주소 ======== {}", uri);
        log.info("응답된 데이터의 바디 (pathvariabletest) =====> {}" , forEntity.getBody());
        return forEntity.getBody();
    }

    // 요청 헤더값과 요청 파라미터를 함께 보내기
    // => RequestEntity를 만들어서 보내기
    // => RestTemplate의 exchange 메소드를 이용해서 작업하기
    public UserInfoRequest exchange() {
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/exchange/test")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        // 방향에 맞게 RequestEntity를 만들어서 요청
        // 사용자가 입력한 request 객체
        // post로 요청
        // 컨텐츠 타입은 json
        // 헤더 토큰 추가
        UserInfoRequest request = new UserInfoRequest("jun", "1234", "전병준");
        RequestEntity<UserInfoRequest> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("authorization", "jwt token")
                .header("mytoken", "tokentoken")
                .body(request);
        ResponseEntity<UserInfoRequest> exchange = restTemplate.exchange(requestEntity, UserInfoRequest.class);
        return exchange.getBody();
    }

    public String naver() {
        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                .path("/v1/search/blog.json")
                .queryParam("query", "spring")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        // 방향에 맞게 RequestEntity를 만들어서 요청
        // 사용자가 입력한 request 객체
        // post로 요청
        // 컨텐츠 타입은 json
        // 헤더 토큰 추가
        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .header("X-Naver-Client-Id", "_nKgKitXwFuXqG3zh1ns")
                .header("X-Naver-Client-Secret", "LPdmqV5GKH")
                .build();
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        log.info(response.getBody());
        return response.getBody();
    }


//    public void naver() {
//        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
//                .path("/v1/search/blog.json")
//                .encode()
//                .build()
//                .toUri();
//        log.info("응답 URI =======> {}", uri);
//        RestTemplate restTemplate = new RestTemplate();
//        ParamTest paramTest = new ParamTest("spring", 10, 1);
//        RequestEntity<String> request = RequestEntity.get(uri)
//                .header("X-Naver-Client-Id", "_nKgKitXwFuXqG3zh1ns")
//                .header("X-Naver-Client-Secret", "LPdmqV5GKH");
//
//        ResponseEntity<String> exchange = restTemplate.exchange(request, String.class);
//        log.info(exchange.toString());
//    }
}
