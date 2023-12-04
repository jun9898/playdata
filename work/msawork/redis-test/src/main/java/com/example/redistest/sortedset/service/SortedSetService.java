package com.example.redistest.sortedset.service;

import com.example.redistest.sortedset.dto.Product;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface SortedSetService {
    //전체 sorted set의 멤버들 조회
    Set<ZSetOperations.TypedTuple<String>> getZsetValues(String key);
    //새로운 member를 저장
    void createMember(Product newProduct);
    //매개변수로 정의한 상품의 rank구하기
    int getRank(Product newProduct);
}
