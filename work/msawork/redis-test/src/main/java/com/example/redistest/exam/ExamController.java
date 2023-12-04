package com.example.redistest.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExamService service;

    @GetMapping("/redisexam1")
    public String getRedisdata(String key){
        String value = service.getRedisValue(key);
        if(value==null){
            //찾는 데이터가 없는 경우
            //사용하려고 하는 데이터를 디비에서 조회해서 레디스에 저장하기
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return value;
    }
    @PostMapping("/redisexam1")
    public Boolean createRedisdata(@RequestBody ExamDTO data){
        service.createRedisValue(data);
        return true;
    }
    @PostMapping("/login")
    public String login(String check,String key){
        String result = service.login(check,key);
        return result;
    }
    @PutMapping("/redisexam1")
    public Boolean updateRedisdata(@RequestBody ExamDTO data){
        service.updateRedisValue(data);
        return true;
    }
    @DeleteMapping("/redisexam1")
    public Boolean deleteRedisdata(String key){
        service.deleteRedisValue(key);
        return true;
    }
}
