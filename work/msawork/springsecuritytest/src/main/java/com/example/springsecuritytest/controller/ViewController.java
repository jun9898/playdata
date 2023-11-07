package com.example.springsecuritytest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String main() {
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

    @GetMapping("/admin/page")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String adminpage() {
        return "AdminPage";
    }

    @GetMapping("/accesserror")
    public String accesserrer() {
        return "accessDenide";
    }
}
