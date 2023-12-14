package com.example.orderservice.application.port.out;

import com.example.orderservice.adapter.in.web.dto.OrderDetailDTO;
import com.example.orderservice.domain.kafka.KafkaSendDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

//producer에 정의할 메소드들
public interface KafkaEventOutputPort {
    //member-service에서도 활용하기 위해서 유저id추가해서 같이 전송
    //1. adapter-out-kafka패키지를 만들고 KafkaProducer_outputAdapter클래스를 만들어서 publish코드를 작성
    //  => List<OrderDetailDTO>를 json문자열로 만들어서 전송
    //2. kafka설정파일 확인
    //3. 서비스에서 주문이 완료되면(myorder테이블과 orderdetail테이블에 데이터가 모두 저장된 것을 확인)
    //   메시지를 카프카로 전송하기(필요하면 미리 만들어 놓은 메소드의 리턴타입을 변경해도 좋다.)
    //4. 테스트는 postman으로 주문이 완료되면
    //   => myorder와 orderdetail테이블에 데이터가 저장
    //   => 카프카console consumer에 전송한 주문내역이 출력

    public void orderEvent(KafkaSendDTO detailDTOS) throws JsonProcessingException;
}
