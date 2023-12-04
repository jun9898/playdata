package com.example.redistest.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

//@Service
@RequiredArgsConstructor
public class ExamService {
    //만료시간 설정
    private final int LIMIT_TIME = 3*60;
    private final StringRedisTemplate template;
    public void createRedisValue(ExamDTO data){
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
    public String login(String check,String key){
        ValueOperations<String,String> stringValueOperations =
                template.opsForValue();
        String returnVal = "";
        if(check.equals("ok")){
            String value = stringValueOperations.get(key);
            if(value==null){
                createRedisValue(new ExamDTO("heaves","myval"));
            }
            returnVal = "로그인성공";
        }else{
            returnVal = "로그인실패";
        }
        return returnVal;
    }
    public void updateRedisValue(ExamDTO data) {
        ValueOperations<String,String> stringValueOperations =  template.opsForValue();
        stringValueOperations.getAndSet(data.getKey(), data.getValue());
    }
    public void deleteRedisValue(String key) {
       template.delete(key);
    }
}
