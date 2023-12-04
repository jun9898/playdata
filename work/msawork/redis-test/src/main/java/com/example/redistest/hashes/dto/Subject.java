package com.example.redistest.hashes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

//hashes
//만료시간을 주지 않는 경우 기본값 -1(만료시간이 없음)
//timeToLive => ttl (만료시간설정)
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "subject",timeToLive = 3000)
public class Subject {
    @Id
    private String id;
    private String name;
    private int price;
    private String info;
}
