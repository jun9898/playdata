package com.example.productservice.domain.kafka;

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
