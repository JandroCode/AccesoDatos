package com.example.TokenJwt.controller;

import com.example.TokenJwt.dto.LoginRequestDTO;
import com.example.TokenJwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
        if(loginRequestDTO.getUsername().equals("pepe")){
            return jwtUtil.generateToken(loginRequestDTO.getUsername());

        }

        return "Usuario no válido";
    }
}
