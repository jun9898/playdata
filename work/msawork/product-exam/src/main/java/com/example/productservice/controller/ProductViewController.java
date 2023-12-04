package com.example.productservice.controller;

import com.example.productservice.dto.ProductResponse;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductViewController {
    private final ProductService service;
    @GetMapping("/getproductlist")
    public String getStores(Model model){
        List<ProductResponse> productlist =   service.findAll();
        System.out.println(productlist);
        model.addAttribute("productlist",productlist);
        return "product/list";
    }
}
