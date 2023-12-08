package com.example.hexagonaltest.Cart.adapter.out.persistence;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartEntity domainToEntity(CartInputDTO cart){
        ModelMapper mapper = new ModelMapper();
        CartEntity entity = mapper.map(cart, CartEntity.class);
        return entity;
    }

    public CartResponseDTO entityToDomain(CartEntity entity){
        ModelMapper mapper = new ModelMapper();
        CartResponseDTO board = mapper.map(entity, CartResponseDTO.class);
        return board;
    }
}
