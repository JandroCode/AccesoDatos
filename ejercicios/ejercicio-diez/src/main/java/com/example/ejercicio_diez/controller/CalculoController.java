package com.example.ejercicio_diez.controller;


import com.example.ejercicio_diez.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculoController {

    @Autowired
    private OperacionService operacionService;



    @GetMapping("/calcular")
    public String calcular(@RequestParam(required = false) Integer a,
                           @RequestParam(required = false) Integer b,
                           @RequestParam(required = false) String operacion, Model model){

        if(operacion.equals("suma") ||
                operacion.equals("resta") ||
                operacion.equals("multiplicacion") ||
                operacion.equals("division")){

            int resultado = operacionService.calculo(a,b, operacion);

            model.addAttribute("resultado" , "El resultado de la " + operacion + " es: " + resultado);
            return "resultado";

        }else{
            model.addAttribute("error" , "Operación no soportada");
            return "vistaError";
        }

    }




}
