package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponseDTO {
    private Long orderId;
    private Date orderDate;
    private String addr;
    private Long customerId;
    private List<OrderDetailResqonseDTO> orderProductList;

    public OrderResponseDTO(Long orderId, Date orderDate, String addr, Long customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.addr = addr;
        this.customerId = customerId;
    }

    public static OrderResponseDTO entityToDTO(OrderEntity entity) {
        OrderResponseDTO dto = new OrderResponseDTO(entity.getOrderId(),
                entity.getOrderDate(),
                entity.getAddr(),
                entity.getCustomerId());
        List<OrderProductEntity> orderProductList = entity.getOrderProductList();
        List<OrderDetailResqonseDTO> dtoList = orderProductList.stream()
                .map(OrderDetailResqonseDTO::entityToDTO)
                .collect(Collectors.toList());
        dto.setOrderProductList(dtoList);
        return dto;
    }
}
