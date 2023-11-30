package com.example.redistest.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/exam")
@RestController
@RequiredArgsConstructor
public class ExamController {

    private final ExamService service;

    @PostMapping("/create")
    public String create(@RequestBody ExamDTO dto) {
        service.create(dto);
        return "ok";
    }

    @GetMapping("/read")
    public String read(String key) {
        return service.read(key);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginExamDTO loginExamDTO) {
        ExamDTO dto = loginExamDTO.getDto();
        String check = loginExamDTO.getCheck();
        String result = service.login(dto, check);
        return result;
    }

    @PutMapping("/update")
    public String update(@RequestBody ExamDTO dto) {
        service.update(dto);
        return "ok";
    }

    @DeleteMapping("/delete")
    public String delete(String key) {
        service.delete(key);
        return "ok";
    }
}
