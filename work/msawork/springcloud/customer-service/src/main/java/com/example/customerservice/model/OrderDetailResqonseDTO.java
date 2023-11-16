package com.example.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DB에서 조회한 주문 정보를 담을 DTO => 클라이언트로 전송 (JSON으로 변환되어)

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailResqonseDTO {
    private Long orderDetailId;
    private Long productNo;
    private int orderPrice; // 구매 가격
    private int count;  // 구매 수량

//    public static OrderDetailResqonseDTO entityToDTO(OrderProductEntity entity) {
//        return OrderDetailResqonseDTO.builder()
//                .orderDetailId(entity.getOrderDetailId())
//                .productNo(entity.getProductNo())
//                .orderPrice(entity.getOrderPrice())
//                .count(entity.getCount())
//                .build();
//    }
}
