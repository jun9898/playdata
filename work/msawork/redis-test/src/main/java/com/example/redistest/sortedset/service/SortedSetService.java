package com.example.redistest.sortedset.service;

import com.example.redistest.sortedset.dto.Product;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface SortedSetService {
    // 전체 sorted set의 멤버들 조회
    public Set<ZSetOperations.TypedTuple<String>> getZsetValues(String key);

    void createMember(Product newProduct);

    int getRank(Product newProduct);
}
