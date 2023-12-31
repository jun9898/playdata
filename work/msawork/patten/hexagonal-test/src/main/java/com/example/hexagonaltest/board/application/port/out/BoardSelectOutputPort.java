package com.example.hexagonaltest.board.application.port.out;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;

import java.util.List;

public interface BoardSelectOutputPort {
    BoardResponseDTO selectBoard(Long id);
    List<BoardResponseDTO> selectAllBoard();
}
