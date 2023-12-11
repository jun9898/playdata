package com.example.hexagonaltest.cart.application.port.in;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.cart.application.port.out.CartCreateOutPort;
import com.example.hexagonaltest.cart.application.usecase.CartCreateUseCase;
import com.example.hexagonaltest.common.InPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartCreateInPort implements CartCreateUseCase {
    private final CartCreateOutPort createOutPort;
    @Override
    public String createCart(CartInputDTO cart) {
        return createOutPort.createCart(cart);
    }
}
