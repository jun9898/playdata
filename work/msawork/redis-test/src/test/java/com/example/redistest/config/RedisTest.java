package com.example.redistest.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    // 스트링 데이터타입 테스트

    @Test
    void testString() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "springtest";
        valueOperations.set(key, "hello");
        String value = valueOperations.get(key);
        System.out.println("value = " + value);
    }

    @Test
    void testSet() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key = "dress";

        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);
        System.out.println("members = " + members);
        System.out.println("size = " + size);
        System.out.println("members.contains(\"prd001\") = " + members.contains("prd001"));
        System.out.println("members.contains(\"prd002\") = " + members.contains("prd002"));
    }

    @Test
    void fruitTest() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key = "fruit";
        setOperations.add("fruit", "mango", "strawberry");
        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);
        for (String member : members) {
            System.out.println("member = " + member);;
        }
        System.out.println("members.contains(\"apple\") = " + members.contains("apple"));
        System.out.println("size = " + size);
    }

}