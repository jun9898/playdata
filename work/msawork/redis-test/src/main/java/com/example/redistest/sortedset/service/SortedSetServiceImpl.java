package com.example.redistest.sortedset.service;

import com.example.redistest.sortedset.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SortedSetServiceImpl implements SortedSetService{

    private final StringRedisTemplate template;

    // sorted set에 저장된 모든 값들 (member의 키와 )
    public Set<ZSetOperations.TypedTuple<String>> getZsetValues(String key) {
        ZSetOperations<String, String> zSetOperations = template.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> outerset = zSetOperations.rangeWithScores(key, 0, -1);
        return outerset;
    }

    @Override
    public void createMember(Product newProduct) {
        ZSetOperations<String, String> zSetOperations = template.opsForZSet();
        zSetOperations.add(newProduct.getCategoryId(), newProduct.getProductId(), newProduct.getPrice());
    }

    @Override
    public int getRank(Product newProduct) {
        ZSetOperations<String, String> zSetOperations = template.opsForZSet();
        int rank = zSetOperations.rank(newProduct.getCategoryId(), newProduct.getProductId()).intValue();
        return rank;
    }
}
