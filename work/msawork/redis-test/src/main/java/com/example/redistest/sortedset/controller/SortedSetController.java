package com.example.redistest.sortedset.controller;

import com.example.redistest.sortedset.service.SortedSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SortedSetController {

    private final SortedSetService service;

    @GetMapping("/getzsetdata")
    public Set<ZSetOperations.TypedTuple<String>> getZsetValue(String key) {
        return service.getZsetValues(key);
    }

}
