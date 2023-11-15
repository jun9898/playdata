package com.example.orderservice.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_table")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long orderId;
    @CreationTimestamp
    private Date orderDate;
    private String addr;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Customer customer;
    private Long customerId;
    @OneToMany(mappedBy = "myorder", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderProductEntity> orderProductList = new ArrayList<>();

    public OrderEntity(String addr, Long customerId) {
        this.addr = addr;
        this.customerId = customerId;
    }

    public void changeOrderProduct(OrderProductEntity orderProduct) {
        orderProductList.add(orderProduct);
        orderProduct.setMyorder(this);
    }

    public static OrderEntity makeOrderEntity(String addr, Long customerId, List<OrderProductEntity> orderProductList) {
        OrderEntity entity = new OrderEntity(addr, customerId);
        for (OrderProductEntity orderProductEntity : orderProductList) {
            entity.changeOrderProduct(orderProductEntity);
        }
        log.info("값 ========================================================== {}", entity.getOrderProductList());
        return entity;
    }
}
