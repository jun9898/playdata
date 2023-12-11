package com.example.hexagonaltest.board.application.service;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.application.port.in.BoardCreateUseCase;
import com.example.hexagonaltest.board.application.port.out.BoardCreateOutputPort;
import com.example.hexagonaltest.board.application.port.out.KafkaEventOutputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 외부 어댑터에 의해서 호출되는 input port의 구현체
// -> serviceImpl의 역할
@Service
@Transactional
@RequiredArgsConstructor
public class BoardCreate implements BoardCreateUseCase {
    // DBMS와 통신하는 output port
    // Kafka와 통신하기
    private final BoardCreateOutputPort outputPort;
    private final KafkaEventOutputPort eventOutputPort;
    @Override
    public String createBoardData(BoardInputDTO board){
        // 이벤트 발행
        String boardMessage = outputPort.createBoard(board);
        // DB에 저장하는 작업과 이벤트를 발행하는 것을 하나로 붂어서 트랜잭션처리가 되도록 작업
        try {
            eventOutputPort.boardWriteEvent("write_ok");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return boardMessage;
    }
}
