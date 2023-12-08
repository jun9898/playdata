package com.example.hexagonaltest.board.adapter.out.persistence;


import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.out.BoardCreateOutputPort;
import com.example.hexagonaltest.board.application.port.out.BoardSelectOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//아웃바운드 어댑터(daoImpl의 역할)
//어댑터와 디비가 어떻게 연동되는지
@Component
@RequiredArgsConstructor
public class JPABoardOutputAdapter implements BoardCreateOutputPort, BoardSelectOutputPort {
    private final BoardRepository repository;
    private final BoardMapper mapper;
    @Override
    public String createBoard(BoardInputDTO board) {
        repository.save(mapper.domainToEntity(board));
        return "ok";
    }

    @Override
    public BoardResponseDTO getBoardData(Long boardNo) {
        return mapper.entityToDomain(repository.findByBoardNo(boardNo));
    }
    @Override
    public List<BoardResponseDTO> getBoardlist() {
        return repository.findAll().stream()
                .map(entity -> mapper.entityToDomain(entity))
                .collect(Collectors.toList());
    }
}
