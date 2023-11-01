package com.example.jpaRestExam.product.controller;

import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.ProductRequest;
import com.example.jpaRestExam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/insert")
    public String insertPage(Model model) {
        // 간단한 작업이므로 Entity를 직접 response 했지만 엔티티는 절대 뷰로 보내면 안된다.
        // ResponseDTO를 만들어서 작업하도록 수정
        List<Category> category = service.getCategory();
        model.addAttribute("categorylist",category);
        System.out.println("============================");
        return "product/prdinsert";
    }

    @PostMapping("/run")
    public String insert(ProductRequest request) {
        log.info("===============================================");
        log.info(request.toString());
        service.insert(request);
        log.info("===============================================");
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("productlist",service.findAll());
        return "product/prdlist";
    }

    @GetMapping("/delete/{productNo}")
    public String delete(@PathVariable Long productNo) {
        return "product/prdlist";
    }
}
