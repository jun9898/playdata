package com.example.hexagonaltest.board.application.port.in;

// 인바운드 포트 - service 패키지의 interface
// 어댑터와 통신하기 위한 동작을 정의한 인터페이스
// 포트는 구체적으로 작업하기 위한 내용이 정의되지 않은 인터페이스

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BoardCreateUseCase {
    String createBoardData(BoardInputDTO board);
}
