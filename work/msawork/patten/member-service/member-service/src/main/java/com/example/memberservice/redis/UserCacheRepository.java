package com.example.memberservice.redis;


import com.example.memberservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserCacheRepository {
    private final RedisTemplate<String, UserDto> redisTemplate;
    //만료시간 - 레디스메모리를 효율적으로 사용하기 위해 작업
    private final static Duration USER_TTL = Duration.ofHours(1);
    //레디스에 저장하기
    public void setUser(UserDto user){
        String key = getKey(user.getUserId()+"");
        redisTemplate.opsForValue().set(key,user,USER_TTL);
    }
    //레디스에서 가져오기
    public UserDto getUser(String key){
        UserDto data = null;
        try{
           data = redisTemplate.opsForValue().get(getKey(key));
            System.out.println("****************************************************************");
            System.out.println(data);
            System.out.println("****************************************************************");
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
    //키조회
    private String getKey(String userId){
        return "user:"+userId;
    }
}
