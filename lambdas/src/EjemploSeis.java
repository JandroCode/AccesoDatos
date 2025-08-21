import java.util.List;

public class EjemploSeis {

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis" , "Laura" , "Pedro" , "Lola");
        nombres.stream()
                .filter( n -> n.startsWith("L"))
                .filter(n -> n.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
