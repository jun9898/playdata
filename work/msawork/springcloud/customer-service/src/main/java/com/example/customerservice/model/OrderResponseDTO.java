package com.example.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

}
