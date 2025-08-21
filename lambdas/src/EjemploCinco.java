import java.util.List;
import java.util.stream.Collectors;

public class EjemploCinco {

    public static void main(String[] args) {

        List<String> nombres = List.of("Ana" , "Beatriz" , "Elisa");

        List<String>  nombresLargos = nombres.stream()
                .filter( nombre -> nombre.length() > 4)
                .toList();

        System.out.println(nombresLargos);

        for(String nombre : nombresLargos){
            System.out.print(nombre +" ");
        }

    }
}
