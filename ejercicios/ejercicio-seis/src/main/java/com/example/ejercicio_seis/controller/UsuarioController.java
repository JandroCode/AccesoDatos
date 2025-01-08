package com.example.ejercicio_seis.controller;

import com.example.ejercicio_seis.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    private  static  final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);


    @GetMapping("/buscar")
    public String buscarUsuario(@RequestParam(required = false) String username, Model model) {


        if (username != null) {
            // Si el parámetro username existe, proceder a buscar el usuario
            boolean usuarioEncontrado = false;
            Usuario usuario = new Usuario();
            List<Usuario> lista = usuario.lista();

            for (Usuario i : lista) {
                if (i.getUsername().equals(username)) {
                    model.addAttribute("usuario", i);  // Pasar el objeto Usuario completo al modelo
                    usuarioEncontrado = true;
                    break;
                }
            }

            if (!usuarioEncontrado) {
                model.addAttribute("mensaje", "Usuario no encontrado");
            }

        }


        return "buscador";  // Devolver la misma vista 'buscador.html'
    }

}
