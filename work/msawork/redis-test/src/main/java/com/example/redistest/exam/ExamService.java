package com.example.redistest.exam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExamService {

    private final StringRedisTemplate template;

    public void create(ExamDTO dto) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        valueOperations.set(dto.getKey(), dto.getValue());
    }

    public String read(String key) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        return valueOperations.get(key);
    }

    public String update(ExamDTO dto) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        return valueOperations.getAndSet(dto.getKey(), dto.getValue());
    }

    public void delete(String key) {
        template.delete(key);
    }

    public String login(ExamDTO dto, String check) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        String returnVal = "";
        if (check.equals("ok")) {
            String value = valueOperations.get(dto.getKey());
            if (value == null) {
                create(dto);
                log.info("로그인 갱신");
            }
            returnVal = "로그인 성공";
            log.info("로그인 성공");
        } else {
            returnVal = "로그인 실패";
            log.info("login false");
        }
        return returnVal;
    }
}
