package com.example.redistest.hashes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "person", timeToLive = -1)
public class Person {

    @Id
    private String id;
    private String ip;
    private LocalDateTime createDateTime;
    private String name;

    public Person from (Person update){
        return Person.builder()
                .id(update.getId())
                .ip(update.getIp())
                .name(update.getName())
                .build();
    }
}
