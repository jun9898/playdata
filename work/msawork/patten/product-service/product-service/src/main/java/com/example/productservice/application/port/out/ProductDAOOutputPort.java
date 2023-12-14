package com.example.productservice.application.port.out;

import com.example.productservice.adapter.out.persistence.Product;
import com.example.productservice.domain.kafka.KafkaSendDTO;

import java.util.List;
import java.util.Map;

public interface ProductDAOOutputPort {
    void write(Product product);  //Product가 Entity
    void insertAll(List<Product> prdlist);
    Product findByProductNo(Long productNo );
    List<Product> findAll();
    //상품수량을 업데이트
    void update(KafkaSendDTO product);
}
