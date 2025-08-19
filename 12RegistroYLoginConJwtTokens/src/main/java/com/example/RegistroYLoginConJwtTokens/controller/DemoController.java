package com.example.RegistroYLoginConJwtTokens.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {



    @GetMapping("/home")
    public Map<String,String> home(){
        return Map.of(
                "saludo" ,  "Hola desde el Home"
        );
    }


    @GetMapping("/admin")
    public Map<String,String> admin(){
        return Map.of(
                "saludo" ,  "Hola Admin !"
        );
    }
}
