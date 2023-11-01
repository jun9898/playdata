package com.example.jpaRestExam.product.model;

import com.example.jpaRestExam.jpatest.relation.DeptEntity;
import com.example.jpaRestExam.jpatest.relation.EmpEntity;
import com.example.jpaRestExam.jpatest.relation.HistoryEntity;
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
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    @CreationTimestamp
    private Date createOrder;
    private String addr;
    private int totalPrice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList = new ArrayList<>();

    public Order(String addr) {
        this.addr = addr;
    }

    public void changeOrderProduct(OrderProduct orderProduct){
        orderProductList.add(orderProduct);
        orderProduct.setOrder(this);
    }

    public static Order buildOrderEntity(String addr, List<OrderProduct> list) {
        Order entity = new Order(addr);
        for (OrderProduct orderProduct : list) {
            entity.changeOrderProduct(orderProduct);
        }
        return entity;
    }
}
