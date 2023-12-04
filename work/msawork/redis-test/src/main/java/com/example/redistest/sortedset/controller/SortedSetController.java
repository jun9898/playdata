package com.example.redistest.sortedset.controller;

import com.example.redistest.sortedset.dto.Product;
import com.example.redistest.sortedset.service.SortedSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SortedSetController {
    private  final SortedSetService service;
    @GetMapping("/getzsetdata")
    public Set<ZSetOperations.TypedTuple<String>> getzsetValues(String key){
        return service.getZsetValues(key);
    }
    @PostMapping("/product")
    public int create(@RequestBody Product newProduct){
       //생성하고 생성된 product의 rank출력
        System.out.println(newProduct);
        service.createMember(newProduct);
        return service.getRank(newProduct);
    }
}
