package com.example.SimpleSpringSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }


}
