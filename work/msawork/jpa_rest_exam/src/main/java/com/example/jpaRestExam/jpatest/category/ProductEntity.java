package com.example.jpaRestExam.jpatest.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    private Long productNo;
    private String productName;
    private String company;
    private String price;
    @ManyToOne
    // 해당 컬럼에 해당되는 값을 ResponseBody로 받아오면 해당 값을 바탕으로 엔티티를 바로 매핑해준다
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ProductEntity(String productName, String company, String price, CategoryEntity category) {
        this.productName = productName;
        this.company = company;
        this.price = price;
        this.category = category;
    }
}
