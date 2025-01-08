package com.example.ejercicio_ocho.controller;

import com.example.ejercicio_ocho.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class HomeController {

    @GetMapping("/producto/{id}")
    public String saludo(@PathVariable Integer id, Model model){


        List<Producto> productos  = new ArrayList<>();

        productos.add(new Producto(1, "Falda" , 30.99));
        productos.add(new Producto(2, "Pantalón" , 90.99));
        productos.add(new Producto(3, "Calcetines" , 2.99));

        productos.forEach( producto-> {
            if(producto.getId() == id){
                //System.out.println(producto.getId()+" "+producto.getNombre()+" "+ producto.getPrecio());

                model.addAttribute("producto" , producto);
            }
        });

        return "productos";






    }
}
