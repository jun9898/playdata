package com.example.productservice.adapter.out.persistence;

import com.example.productservice.application.port.out.ProductDAOOutputPort;
import com.example.productservice.domain.kafka.KafkaSendDTO;
import com.example.productservice.domain.kafka.OrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDAOOutputAdapter implements ProductDAOOutputPort {
    private final ProductRepository repository;
    @Override
    public void write(Product product) {

    }

    @Override
    public void insertAll(List<Product> prdlist) {
        repository.saveAll(prdlist);
    }

    @Override
    public Product findByProductNo(Long productNo) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(KafkaSendDTO product) {
        //조회하기
        for(OrderItem dto:product.getOrderproductlist()) {
            Product entity = repository.findById(dto.getProductNo()).get();
            log.info("조회=>{}", entity);
            if (entity != null) {
                //재고 수정
                entity.setStock(entity.getStock() - (Integer) dto.getCount());
                repository.save(entity);
            }
        }
    }
}
