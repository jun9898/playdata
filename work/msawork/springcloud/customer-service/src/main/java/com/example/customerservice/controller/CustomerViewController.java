package com.example.customerservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

    @RequestMapping("/mypage")
    @ResponseBody
    public Authentication mypage() {
        System.out.println("============================");
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/create")
    public String createUser() {
        return "customer/register";
    }

    @GetMapping("/login")
    public String login() {
        return "customer/loginForm";
    }


    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "customer/loginForm";
    }

    @GetMapping("/mypage")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String userpage() {
        return "customer/UserPage";
    }

    @GetMapping("/accesserror")
    public String accesserrer() {
        return "accessDenide";
    }

}
