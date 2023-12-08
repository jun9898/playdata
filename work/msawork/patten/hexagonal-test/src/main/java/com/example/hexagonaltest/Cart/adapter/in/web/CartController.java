package com.example.hexagonaltest.Cart.adapter.in.web;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.Cart.application.usecase.CartCreateUseCase;
import com.example.hexagonaltest.Cart.application.usecase.CartSelectUseCase;
import com.example.hexagonaltest.common.WebInAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//인바운드 어댑터
@WebInAdapter
@RestController
@RequiredArgsConstructor
public class CartController {
    //서비스 상위 정의하고 작업 - port in의 usecase
    private final CartCreateUseCase cartCreateUseCase;
    private final CartSelectUseCase cartSelectUseCase;
    @PostMapping("/boardcreate")
    public ResponseEntity<String> createBoard(@RequestBody CartInputDTO cart){
        String result = cartCreateUseCase.createCartData(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/getBoard/{cartNo}")
    public ResponseEntity<CartResponseDTO> getBoardData(@PathVariable Long cartNo) {
        CartResponseDTO cartResponseDTO = cartSelectUseCase.getCartData(cartNo);
        return ResponseEntity.ok(cartResponseDTO);
    }

    @GetMapping("/getBoard")
    public ResponseEntity<List<CartResponseDTO>> getAllBoardData() {
        List<CartResponseDTO> cartResponseDTO = cartSelectUseCase.getAllCartData();
        return ResponseEntity.ok(cartResponseDTO);
    }


}

