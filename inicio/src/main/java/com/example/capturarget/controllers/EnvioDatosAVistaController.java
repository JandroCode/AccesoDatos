package com.example.capturarget.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.capturarget.controllers.model.Persona;

@Controller
public class EnvioDatosAVistaController {


    @GetMapping("/persona")
    public String home(Model model){
        String nombre = "Juan";
        Integer edad = 34;

        // model.addAttribute("nombre", nombre);
        // model.addAttribute("edad", edad);
        return "personas";
    }


    
    @GetMapping("/personas")
    public String listaPersonas(Model model){

        List<String> personas = new ArrayList<>();

        personas.add("Juan");
        personas.add("Lucas");
        personas.add("Silvia");

        model.addAttribute("personas", personas);
       
   
        return "personas";
    }


    @GetMapping("/personas-from-model")
    public String listaPersonaDesdeElModelo(Model model){

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona(1, "Juan" , "juan@es.es"));
        personas.add(new Persona(2, "Silvia" , "silvia@es.es"));

   
        model.addAttribute("personas", personas);
       
   
        return "personasFromModel";
    }



    
}
