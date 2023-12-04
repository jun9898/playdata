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
    private RedisTemplate<String,String> redisTemplate;
    //스트링데이터타입 테스트
    @Test
    void testString(){
        ValueOperations<String,String> valueOperations =
                redisTemplate.opsForValue();
        String key = "springtest";
        valueOperations.set(key,"hello");
        String value=valueOperations.get(key);
        System.out.println(value+"===============================");
    }
    @Test
    void testSet(){
        SetOperations<String, String> setOperations
                                = redisTemplate.opsForSet();
        String key= "dress";
        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);
        System.out.println(members);
        System.out.println(size);
        System.out.println(members.contains("prd002"));
        System.out.println(members.contains("prd0021"));
    }
    @Test
    void examSet(){
//        - fruit set만들고 데이터 5개 넣기
        SetOperations<String,String> newset = redisTemplate.opsForSet();
        String key = "fruit";
        newset.add(key,"banana");
        newset.add(key,"apple");
        newset.add(key,"mango");
        newset.add(key,"melon");
        newset.add(key,"딸기");


//        - set에 저장된 전체 데이터 조회하기
        Set<String> members = newset.members(key);
        System.out.println(members);

//        - apple이 있는지 조회
        System.out.println(members.contains("apple"));
//        - fruit의 전체 갯수
        Long size = newset.size(key);
        System.out.println(size);
//
    }
}