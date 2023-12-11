package com.example.hexagonaltest.cart.application.port.out;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartInputDTO;

public interface CartCreateOutPort {
    String createCart(CartInputDTO cart);
}
