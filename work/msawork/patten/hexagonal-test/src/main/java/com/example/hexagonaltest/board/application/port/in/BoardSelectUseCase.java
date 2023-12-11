package com.example.hexagonaltest.board.application.port.in;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;

import java.util.List;

public interface BoardSelectUseCase {
    BoardResponseDTO selectBoard(Long id);
    List<BoardResponseDTO> selectAllBoard();
}
