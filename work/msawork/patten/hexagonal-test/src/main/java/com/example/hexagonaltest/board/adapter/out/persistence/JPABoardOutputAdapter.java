package com.example.hexagonaltest.board.adapter.out.persistence;

// 아웃바운드어댑터 (daoImpl 의 역할)
// 어댑터와 디비가 어떻게 연동되는지 정의

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.out.BoardCreateOutputPort;
import com.example.hexagonaltest.board.application.port.out.BoardSelectOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaBoardOutputAdapter implements BoardCreateOutputPort, BoardSelectOutputPort {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    public String createBoard(BoardInputDTO board) {
        boardRepository.save(boardMapper.domainToEntity(board));
        return "ok";
    }

    @Override
    public BoardResponseDTO selectBoard(Long id) {
        BoardEntity entity = boardRepository.findById(id).get();
        return boardMapper.entityToDomain(entity);
    }

    @Override
    public List<BoardResponseDTO> selectAllBoard() {
        List<BoardEntity> all = boardRepository.findAll();
        List<BoardResponseDTO> boardList = all.stream().map(entity -> {
            return boardMapper.entityToDomain(entity);
        }).collect(Collectors.toList());
        
        return boardList;
    }
}
