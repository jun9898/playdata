package com.example.jpaRestExam.product.model;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long orderProductId;
    private int discount;
    private int quantity;

    @ManyToOne
    @Setter
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_no")
    private Product product;


}
