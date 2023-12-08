package com.example.hexagonaltest.Cart.adapter.out.persistence;


import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.Cart.application.port.out.CartCreateOutputPort;
import com.example.hexagonaltest.Cart.application.port.out.CartSelectOutputPort;
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
public class JPACartOutputAdapter implements CartCreateOutputPort, CartSelectOutputPort {
    private final CartRepository repository;
    private final CartMapper mapper;
    @Override
    public String createBoard(CartInputDTO board) {
        repository.save(mapper.domainToEntity(board));
        return "ok";
    }

    @Override
    public CartResponseDTO getCartData(Long boardNo) {
        return mapper.entityToDomain(repository.findByCartNo(boardNo));
    }
    @Override
    public List<CartResponseDTO> getCartlist() {
        return repository.findAll().stream()
                .map(entity -> mapper.entityToDomain(entity))
                .collect(Collectors.toList());
    }
}
