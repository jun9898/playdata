package com.example.hexagonaltest.cart.application.port.out;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;

import java.util.List;

public interface CartSelectOutPort {
    CartResponseDTO selectCart(Long id);
    List<CartResponseDTO> selectAllCart();
}
