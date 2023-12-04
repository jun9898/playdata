package com.example.redistest.exam02.map.service;


import com.example.redistest.exam02.map.dto.StoreResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapRedisService {

    private final RedisTemplate<String, String> redisTemplate;
    // store에 저장된 레코드를 json 문자열로 변환하고 json 문자열로 정의된 store데이터를 dto 객체로 변환하기 위해 ObjectMapper를 사용
    private final ObjectMapper objectMapper;
    private HashOperations<String, String, String> hashOperations;
    // service가 실행되기 전에 초기화작업을 진행
    // HashOperations이 매번 초기화 되지 않고 빈의 라이프사이클에서 한번만 딱 실행해서 초기화할 수 있도록 작업

    // WAS가 실행되면서 빈이 생성될때 딱 한번 초기화함
    @PostConstruct
    public void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    // 디비에이터를 조회해서 레디스에 저장하기
    // => Store테이블에 있는 데이터를 redis에 동일하게 동기화를 위해서 저장
    public void save(StoreResponseDTO storeDTO) {
        try {
            hashOperations.put("store", storeDTO.getId().toString(), // 서브키
                                             serializeStoreDTO(storeDTO) // dto -> json문자열로 변환
                    );
            System.out.println("storeDTO.toString() = " + storeDTO.toString());
        } catch (JsonProcessingException e) {
            System.out.println("저장 오류" + e.getMessage());
        }
    }

    // DTO를 json 문자열로 변환
    private String serializeStoreDTO(StoreResponseDTO storeResponseDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(storeResponseDTO);
    }

    // json 문자열을 DTO로 변환
    private StoreResponseDTO deserializeStoreDTO(String value) throws JsonProcessingException {
        return objectMapper.readValue(value, StoreResponseDTO.class);
    }

    // Redis에 저장된 데이터를 조회
    public List<StoreResponseDTO> redisFindAll() {
        List<StoreResponseDTO> list = new ArrayList<>();

        // store키로 저장된 모든 서브키밸류를 조회해서 values만 빼서 반복작업
        // value 하나를 dto로 변경
        try {
            for (String value : hashOperations.entries("store").values()) {
                StoreResponseDTO dto = deserializeStoreDTO(value);
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            // redis에서 데이터를 조회하는데 에러 발생된 상황 - 문제가 발생되면
            return Collections.emptyList(); // 빈 리스트를 리턴해서 문제가 있음을 알려주기
        }
    }
}
