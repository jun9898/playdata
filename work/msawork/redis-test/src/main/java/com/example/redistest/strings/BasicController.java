package com.example.redistest.strings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class BasicController {
    private final BasicService service;

    @GetMapping("/redisdata")
    public String getRedisdata(String key){
        String value = service.getRedisValue(key);
        if(value==null){
            //찾는 데이터가 없는 경우
            //사용하려고 하는 데이터를 디비에서 조회해서 레디스에 저장하기
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        return value;
    }
    @PostMapping("/redisdata")
    public Boolean createRedisdata(@RequestBody BasicDTO data){
        service.createRedisValue(data);
        return true;
    }

    @PutMapping("/redisdata")
    public Boolean updateRedisdata(@RequestBody BasicDTO data){
        service.updateRedisValue(data);
        return true;
    }
    @DeleteMapping("/redisdata")
    public Boolean deleteRedisdata(String key){
        service.deleteRedisValue(key);
        return true;
    }
}
