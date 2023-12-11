package com.example.hexagonaltest.board.application.port.out;

// 아웃바운드 포트 - dao단의 dao인터페이스

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;

public interface BoardCreateOutputPort {
    String createBoard(BoardInputDTO board);
}
