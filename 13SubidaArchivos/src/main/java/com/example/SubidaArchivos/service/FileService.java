package com.example.SubidaArchivos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileService {


    private static final Logger LOG = LoggerFactory.getLogger(FileService.class);


    // Carpeta donde se guardarán los archivos
    private final Path uploadDir = Paths.get("uploads");


    // Constructor para crear la carpeta si no existe
    public FileService() throws IOException {
        if(!Files.exists(uploadDir)){
            Files.createDirectories(uploadDir);
        }
    }


    // Método para guardar el archivo
    public String saveFile(MultipartFile file) throws IOException{


        // Limpiar el archivo para evitar caracteres peligrosos
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String uniqueFileName  = UUID.randomUUID().toString() +"_" + fileName;

        LOG.info("Nombre de archivo:"+uniqueFileName);


        // Ruta completa al archivo incluyendo el nombre del archivo
        Path targetLocation = uploadDir.resolve(uniqueFileName);


        // Guardar el archivo en el directorio indicado
        Files.copy(file.getInputStream(), targetLocation);
        return fileName;
    }


    // Método para listar imágenes
    public List<String> listAllFiles() throws IOException{
        return Files.list(uploadDir)
                .filter(Files::isRegularFile) // Solo obtiene los archivos ignorando las carpetas
                .map(Path::getFileName) // Obtiene el nombre del archivo
                .map(Path::toString)  // Convierte el tipo Path a un tipo String
                .collect(Collectors.toList());  // Recopila todos los nombres filtrados y los devuelve en una lista
    }


}
