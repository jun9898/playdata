package com.example.redistest.strings;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BasicService {
    //만료시간 설정
    private final int LIMIT_TIME = 3*60;
    private final RedisTemplate template;
    public void createRedisValue(BasicDTO data){
        ValueOperations<String,String> stringValueOperations =
                template.opsForValue();
        stringValueOperations.set(data.getKey(),data.getValue());
        //만료시간 설정
        //stringValueOperations.set(data.getKey(),data.getValue(),LIMIT_TIME);
    }
    public String getRedisValue(String key){
        ValueOperations<String,String> stringValueOperations =
                template.opsForValue();
        String value = stringValueOperations.get(key);

        return value;
    }

    public void updateRedisValue(BasicDTO data) {
        ValueOperations<String,String> stringValueOperations =  template.opsForValue();
        stringValueOperations.getAndSet(data.getKey(), data.getValue());
    }
    public void deleteRedisValue(String key) {
       template.delete(key);
    }
}
