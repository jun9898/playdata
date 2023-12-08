package com.example.hexagonaltest.board.application.port.in;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.out.BoardSelectOutputPort;
import com.example.hexagonaltest.board.application.usecase.BoardSelectUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardSelectInport implements BoardSelectUseCase {
    private final BoardSelectOutputPort outputPort;

    @Override
    public BoardResponseDTO getBoardData(Long boardNo) {
        return outputPort.getBoardData(boardNo);
    }

    @Override
    public List<BoardResponseDTO> getAllBoardData() {
        return outputPort.getBoardlist();
    }
}
