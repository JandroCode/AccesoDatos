package com.example.SpringSecurityIntro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnlacesController {

    @GetMapping("/enlaces")
    public String enlaces(){
        return "enlaces";
    }
}
