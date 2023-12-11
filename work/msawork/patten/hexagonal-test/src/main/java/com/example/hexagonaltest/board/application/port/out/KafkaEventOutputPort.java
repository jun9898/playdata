package com.example.hexagonaltest.board.application.port.out;

import com.example.hexagonaltest.board.domain.MyNotiData;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaEventOutputPort {
    public void boardWriteEvent(String msg) throws JsonProcessingException;
    public void notieWriteEvent(MyNotiData data) throws JsonProcessingException;
}
