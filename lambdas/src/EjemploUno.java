import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EjemploUno {
    public static void main(String[] args) {
        /*
                Las expresiones lambda son funciones anónimas que permiten
                pasar comportamiento como argumento, simplificando el código.
         */

        // Ejemplo 1
        List<String> nombres = List.of("Ana" , "Luis" , "Laura");

        // Filtrar nombres que comienzan con "L" y convertirlos a mayúsculas
        List<String> nombresFiltrados = nombres.stream()
                .filter(n -> n.startsWith("L"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());


        System.out.println(nombresFiltrados);

    }
}