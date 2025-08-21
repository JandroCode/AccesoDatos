import java.util.List;

public class EjemploSiete {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(5, 10, 3, 8 , 20, 7);
        List<Integer> mayoresDeCinco = numeros.stream()
                .filter(n -> n > 5)
                .sorted()
                .toList();

        System.out.println(mayoresDeCinco);

    }
}
