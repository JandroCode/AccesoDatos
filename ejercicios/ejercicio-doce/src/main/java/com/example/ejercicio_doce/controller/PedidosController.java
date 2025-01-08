package com.example.ejercicio_doce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PedidosController {


    @GetMapping("/pedido/{numero}")
    public String pedidos(@PathVariable Integer numero , Model model){

        Map<Integer,String> pedidos = new HashMap<>();

        pedidos.put(1234 , "Enviado");
        pedidos.put(1235 , "En proceso");
        pedidos.put(1236 , "Entregado");

        String pedidoBuscado = pedidos.get(numero);

        if(pedidoBuscado != null){
            model.addAttribute("estadoPedido" , pedidos.get(numero));
        }else{
            model.addAttribute("estadoPedido" , "El pedido no existe");
        }



        return "pedidos";



    }




}
