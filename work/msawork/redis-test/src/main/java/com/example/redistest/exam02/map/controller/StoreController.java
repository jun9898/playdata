package com.example.redistest.exam02.map.controller;

import com.example.redistest.exam02.map.dto.StoreResponseDTO;
import com.example.redistest.exam02.map.service.MapRedisService;
import com.example.redistest.exam02.map.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;
    private final MapRedisService redisService;

    @GetMapping("/getRestStorelist")
    public List<StoreResponseDTO> getStores(Model model, double latitude, double longitude){
        System.out.println("latitude = " + latitude);
        System.out.println("longitude = " + longitude);
        List<StoreResponseDTO> storelist = service.getStoreFilter(latitude, longitude);
        System.out.println(storelist);
        model.addAttribute("storelist", storelist);
        return storelist;
    }

    @GetMapping("/redis/save")
    public String save() {
        // 디비에 있는 모든 데이터를 조회해서 redis에 저장하기
        List<StoreResponseDTO> storeList = service.getStoreList();
        storeList.forEach(redisService :: save);
        return "success";
    }

    @GetMapping("/getdbselect")
    public List<StoreResponseDTO> getdbStores(){
        List<StoreResponseDTO> storelist = service.getStoreList();
        System.out.println("디비 조회");
        System.out.println(storelist);
        return storelist;
    }

    @GetMapping("/getredisselect")
    public List<StoreResponseDTO> getRedisStores(){
        List<StoreResponseDTO> storelist = service.getRedisStoreFilter();
        System.out.println("레디스 조회 캐싱");
        System.out.println(storelist);
        return storelist;
    }
}