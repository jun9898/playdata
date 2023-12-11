package com.example.hexagonaltest.cart.adapter.out.persistence;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.cart.adapter.out.persistence.CartRepository;
import com.example.hexagonaltest.cart.application.port.out.CartCreateOutPort;
import com.example.hexagonaltest.cart.application.port.out.CartSelectOutPort;
import com.example.hexagonaltest.common.WebOutAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartOutAdapter implements CartCreateOutPort , CartSelectOutPort {
    private final CartRepository cartRepository;

    @Override
    public String createCart(CartInputDTO cart) {
        cartRepository.save(cart.toEntity());
        return "save";
    }

    @Override
    public CartResponseDTO selectCart(Long id) {
        CartEntity entity = cartRepository.findById(id).get();
        return entity.toResponseDTO();
    }

    @Override
    public List<CartResponseDTO> selectAllCart() {
        List<CartEntity> all = cartRepository.findAll();
        return all.stream().map(entity -> {
            return entity.toResponseDTO();
        }).collect(Collectors.toList());
    }
}
