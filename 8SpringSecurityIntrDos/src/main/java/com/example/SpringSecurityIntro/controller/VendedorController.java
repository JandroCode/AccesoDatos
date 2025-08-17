package com.example.SpringSecurityIntro.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
public class VendedorController {


    @GetMapping("/vendedor")
    public String vendedor(){
        return "vendedor";
    }
}
