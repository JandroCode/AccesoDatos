package com.example.SpringSecurityWithDataBase.controller;

import com.example.SpringSecurityWithDataBase.dto.RegisterDTO;
import com.example.SpringSecurityWithDataBase.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("registerDto" , new RegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDTO registerDTO){
        registerService.register(registerDTO);
        return "redirect:/login?registered";
    }
}
