package com.example.hexagonaltest.board.application.service;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.in.BoardSelectUseCase;
import com.example.hexagonaltest.board.application.port.out.BoardSelectOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardSelectInPort implements BoardSelectUseCase {
    private final BoardSelectOutputPort boardSelectOutputPort;
    @Override
    public BoardResponseDTO selectBoard(Long id) {
        return boardSelectOutputPort.selectBoard(id);
    }

    @Override
    public List<BoardResponseDTO> selectAllBoard() {
        return boardSelectOutputPort.selectAllBoard();
    }
}
