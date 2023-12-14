package com.example.memberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long orderDetailId;
    private Long productNo;
    private int orderPrice;//구매가격
    private int count;//주문수량
}
