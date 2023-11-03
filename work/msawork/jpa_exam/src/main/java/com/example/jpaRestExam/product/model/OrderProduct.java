package com.example.jpaRestExam.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductId;

    private int discountPrice;
    private int quantity;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @Setter
    @JoinColumn(name = "order_id")
    private Order order_column;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @JoinColumn(name = "product_no")
    private Product product;

    public OrderProduct(int discountPrice, int quantity, Product product) {
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.product = product;
    }
}
