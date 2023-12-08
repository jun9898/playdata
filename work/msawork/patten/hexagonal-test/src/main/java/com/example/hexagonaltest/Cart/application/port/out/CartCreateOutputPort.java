package com.example.hexagonaltest.Cart.application.port.out;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;

//아웃바운드포트 - dao단의 dao인터페이스
public interface CartCreateOutputPort {
    String createBoard(CartInputDTO cart);
}

