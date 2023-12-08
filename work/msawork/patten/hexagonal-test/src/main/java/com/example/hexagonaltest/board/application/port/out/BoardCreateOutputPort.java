package com.example.hexagonaltest.board.application.port.out;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;

//아웃바운드포트 - dao단의 dao인터페이스
public interface BoardCreateOutputPort {
    String createBoard(BoardInputDTO board);
}

