package com.example.productservice.application.service;

import com.example.productservice.application.port.in.ProductServiceInPort;
import com.example.productservice.adapter.in.web.dto.ProductRequest;
import com.example.productservice.adapter.in.web.dto.ProductResponse;
import com.example.productservice.adapter.out.persistence.Category;
import com.example.productservice.adapter.out.persistence.Product;
import com.example.productservice.application.port.out.CategoryDAOOutputPort;
import com.example.productservice.application.port.out.ProductDAOOutputPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServiceInPort {
    private  final ProductDAOOutputPort productDAOOutputPort;
    private  final CategoryDAOOutputPort categoryDAOOutputPort;
    @Override
    public void write(ProductRequest product) {

    }

    @Override
    public ProductResponse findByProductNo(Long productNo) {
        return null;
    }

    @Override
    public List<ProductResponse> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<ProductResponse> productlist = productDAOOutputPort.findAll()
                .stream()
                .map(store -> mapper.map(store,ProductResponse.class))
                .collect(Collectors.toList());
        return productlist;
    }

    @Override
    @Transactional
    public void insertAll(List<ProductRequest> prdlist) {
        ModelMapper mapper = new ModelMapper();
        //카테고리정보 조회하기
        Category category = categoryDAOOutputPort.findByCategoryId(1L);
        //DTO -> 엔티티로 변환
        List<Product> list = prdlist.stream()
                .map((item) ->{
                    item.setCategory(category);
                    return mapper.map(item,Product.class);
                }).collect(Collectors.toList());
        System.out.println(list);
        productDAOOutputPort.insertAll(list);
    }
}














