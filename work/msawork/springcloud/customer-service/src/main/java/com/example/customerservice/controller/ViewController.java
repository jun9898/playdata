package com.example.customerservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/mylogin")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "loginForm";
    }

    @GetMapping("/user/page")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String userpage() {
        return "UserPage";
    }

}
