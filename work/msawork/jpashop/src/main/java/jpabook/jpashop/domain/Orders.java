package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @CreationTimestamp
    private Date orderdate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
