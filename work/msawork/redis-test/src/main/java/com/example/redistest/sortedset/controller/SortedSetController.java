package com.example.redistest.sortedset.controller;

import com.example.redistest.sortedset.dto.Product;
import com.example.redistest.sortedset.service.SortedSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SortedSetController {

    private final SortedSetService service;

    @GetMapping("/getzsetdata")
    public Set<ZSetOperations.TypedTuple<String>> getZsetValue(String key) {
        return service.getZsetValues(key);
    }

    @PostMapping("/product")
    public int create(@RequestBody Product newProduct) {
        // 생성된 Product의 rank 출력
        System.out.println("newProduct.toString() = " + newProduct.toString());
        service.createMember(newProduct);
        return service.getRank(newProduct);
    }
}