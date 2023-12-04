package com.example.redistest.exam02.map.controller;

import com.example.redistest.exam02.map.dto.StoreResponseDTO;
import com.example.redistest.exam02.map.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final StoreService service;
    @GetMapping("/showpage")
    public String showmap(){
        return "map/test2";
    }

    @GetMapping("/getStorelist")
    public String getStores(Model model, double latitude, double longitude){
        List<StoreResponseDTO> storelist = service.getStoreFilter(latitude, longitude);
        System.out.println(storelist);
        model.addAttribute("storelist", storelist);
        return "map/test3";
    }

}
