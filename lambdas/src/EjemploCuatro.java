import java.util.List;


public class EjemploCuatro {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(1,2,3,4,5,6);

        List<Integer> pares = numeros.stream()
                .filter( n -> n % 2 == 0)
                .toList();

        System.out.println(pares);

    }
}
