package com.example.redistest.hashes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "subject", timeToLive = -1)
public class Subject {
    @Id @Indexed
    private String id;
    private String name;
    private int price;
    private String info;
}
