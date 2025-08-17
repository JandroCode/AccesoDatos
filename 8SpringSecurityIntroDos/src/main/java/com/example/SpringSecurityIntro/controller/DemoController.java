package com.example.SpringSecurityIntro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'GESTOR', 'VENDEDOR')")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "admin";
    }

    @GetMapping("/gestor")
    @PreAuthorize("hasRole('GESTOR')")
    public String gestor(){
        return "gestor";
    }



}
