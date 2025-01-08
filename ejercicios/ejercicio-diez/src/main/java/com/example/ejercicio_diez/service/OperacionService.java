package com.example.ejercicio_diez.service;

import org.springframework.stereotype.Service;

@Service
public class OperacionService {

    public int calculo(int a, int b, String operacion){

        int resultado = 0;

        switch (operacion){
            case "suma":
                resultado = a+b;
                break;
            case "resta":
                resultado = a-b;
                break;
            case "multiplicacion":
                resultado = a*b;
                break;
            case "division":
                resultado = a/b;
                break;
        }
        return  resultado;
    }
}
