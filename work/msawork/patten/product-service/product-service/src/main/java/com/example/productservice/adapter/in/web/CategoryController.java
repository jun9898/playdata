package com.example.productservice.adapter.in.web;

import com.example.productservice.adapter.in.web.dto.CategoryRequest;
import com.example.productservice.application.port.in.CategoryServiceInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceInPort service;
    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestBody
                                                CategoryRequest requestdto){
        service.write(requestdto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
