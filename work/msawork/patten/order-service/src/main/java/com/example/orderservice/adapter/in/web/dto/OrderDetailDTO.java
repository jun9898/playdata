package com.example.orderservice.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
//필요한 데이터를 담은 dto를 재사용하지 않고 카프카전송용으로 dto를 따로 만들어서
//관리하는 것이 일반적
public class OrderDetailDTO {
    private Long productNo;
    private int orderPrice;//구매가격
    private int count;//주문수량
}
