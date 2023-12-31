package com.example.hexagonaltest.board.adapter.out.persistence;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
    public BoardEntity domainToEntity(BoardInputDTO board){
        ModelMapper mapper = new ModelMapper();
        BoardEntity entity = mapper.map(board, BoardEntity.class);
        return entity;
    }

    public BoardResponseDTO entityToDomain(BoardEntity board){
        ModelMapper mapper = new ModelMapper();
        BoardResponseDTO dto = mapper.map(board, BoardResponseDTO.class);
        return dto;
    }
}
