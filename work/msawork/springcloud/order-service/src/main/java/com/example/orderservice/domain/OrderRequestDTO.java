package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private String addr;
    private Long customerId;
    private List<OrderDetailDTO> orderDetailDTOList;
}
