package com.example.orderservice.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Long productNo;
    private int orderPrice;//구매가격
    private int count;//주문수량
}
