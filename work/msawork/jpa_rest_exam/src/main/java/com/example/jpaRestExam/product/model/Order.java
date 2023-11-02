package com.example.jpaRestExam.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    @CreationTimestamp
    private Date createOrder;
    private String addr;
    private int totalPrice;
    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;
    @OneToMany(mappedBy = "order_column", cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProductList = new ArrayList<>();

    public Order(String addr) {
        this.addr = addr;
    }

    public void changeOrderProduct(OrderProduct orderProduct){
        orderProductList.add(orderProduct);
        orderProduct.setOrder_column(this);
    }

    public static Order buildOrderEntity(String addr, List<OrderProduct> list) {
        Order entity = new Order(addr);
        for (OrderProduct orderProduct : list) {
            entity.changeOrderProduct(orderProduct);
        }
        return entity;
    }
}
