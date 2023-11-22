package com.example.productservice.dao;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO{
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
        return null;
    }

    @Override
    public void update(Map<Object, Object> product) {
        int key = (Integer) product.get("productNo");
        log.info("{}",key);
        Product productEntity = repository.getReferenceById(new Long(key));
        log.info("조회 ============> {}", productEntity.toString());
        if (productEntity != null) {
            productEntity.setStock(productEntity.getStock() - (Integer) product.get("count"));
        }
    }
}
