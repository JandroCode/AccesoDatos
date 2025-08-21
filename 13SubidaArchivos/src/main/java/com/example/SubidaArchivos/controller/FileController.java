package com.example.SubidaArchivos.controller;

import com.example.SubidaArchivos.service.FileService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/")
    public String form(){
        return "form";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes flash) {
        try {
            String fileName = fileService.saveFile(file);
            flash.addFlashAttribute("message" , "Archivo subido correctamente");

        }catch (IOException e){
            flash.addFlashAttribute("message" , "Error al subir el archivo "+ e.getMessage());
        }

        return "redirect:/";

    }

    @GetMapping("/list")
    public String listFiles(Model model) throws IOException{
        model.addAttribute("images" , fileService.listAllFiles());
        return "list";
    }


}
