package com.example.hexagonaltest.cart.adapter.in.web;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.cart.application.usecase.CartCreateUseCase;
import com.example.hexagonaltest.cart.application.usecase.CartSelectUsecase;
import com.example.hexagonaltest.common.WebInAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@WebInAdapter
@RestController
@RequiredArgsConstructor
public class CartControllerInAdapter {
    private final CartCreateUseCase createUseCase;
    private final CartSelectUsecase selectUsecase;

    @PostMapping("/carts")
    public String createCart(@RequestBody CartInputDTO cart){
        return createUseCase.createCart(cart);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<CartResponseDTO> selectCart(@PathVariable(name = "id") Long id){
        System.out.println("선택");
        CartResponseDTO cartResponseDTO = selectUsecase.selectCart(id);
        return ResponseEntity.ok(cartResponseDTO);
    }
    @GetMapping("/carts")
    public ResponseEntity<List<CartResponseDTO>> selectAllCart(){
        System.out.println("전체");
        List<CartResponseDTO> cartResponseDTOS = selectUsecase.selectAllCart();
        return ResponseEntity.ok(cartResponseDTOS);
    }
}
