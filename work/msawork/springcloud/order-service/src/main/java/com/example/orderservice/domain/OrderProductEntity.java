package com.example.orderservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderdetail")
public class OrderProductEntity {

    @Id
    @GeneratedValue
    private Long orderDetailId;

//    @ManyToOne
//    @JoinColumn(name = "product_no")
//    private Product product;

    private Long productNo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "order_id")
    private OrderEntity myorder;
    private int orderPrice; // 구매 가격
    private int count;  // 구매 수량

    public OrderProductEntity(Long productNo, OrderEntity myorder, int orderPrice, int count) {
        this.productNo = productNo;
        this.myorder = myorder;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public OrderProductEntity(Long productNo, int orderPrice, int count) {
        this.productNo = productNo;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}