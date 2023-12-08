package com.example.hexagonaltest.board.application.port.in;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.application.port.out.BoardCreateOutputPort;
import com.example.hexagonaltest.board.application.usecase.BoardCreateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//외부 어댑터에 의해서 호출되는 input port의 구현체
//=> serviceImpl의 역할
@Service
@Transactional
@RequiredArgsConstructor
public class BoardCreate implements BoardCreateUseCase {
    private final BoardCreateOutputPort outputPort;
    @Override
    public String createBoardData(BoardInputDTO board) {
        return outputPort.createBoard(board);
    }
}
