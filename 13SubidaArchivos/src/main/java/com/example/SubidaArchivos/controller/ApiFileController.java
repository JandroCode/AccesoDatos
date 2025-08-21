package com.example.SubidaArchivos.controller;

import com.example.SubidaArchivos.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiFileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try {
            fileService.saveFile(file);
            return ResponseEntity.ok("Archivo subido correctamente");

        }catch (IOException e){
            return ResponseEntity.badRequest().body("Error al subir el archivo " + e.getMessage());
        }
    }


    @GetMapping("/images")
    public List<String> getImages() throws IOException{
        List<String> fileNames = fileService.listAllFiles();

        return fileNames.stream().map(name -> "/uploads/" +name)
                .collect(Collectors.toList());

    }
}
