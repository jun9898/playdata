package com.example.frontserver.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerViewController {

    @GetMapping("/create")
    public String create() {
        return "customer/register";
    }

    @GetMapping("/login")
    public String login() {
        return "customer/loginForm";
    }

    @GetMapping("/mypage")
    @ResponseBody
    public String mypage(String request, Model model) {
        log.info("test ===========================> {}", request);
        return "customer/userPage";
    }

}
