package com.example.hexagonaltest.cart.application.usecase;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartInputDTO;

public interface CartCreateUseCase {
    String createCart(CartInputDTO cart);
}
