package com.example.orderservice.domain.kafka;

import com.example.orderservice.domain.entity.OrderProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaSendDTO {
    private Long orderId;
    private Long customerId;
    private List<OrderItem> orderproductlist = new ArrayList<>();
}
