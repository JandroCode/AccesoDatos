public class EjemploDos {

    public static void main(String[] args) {

        Thread hilo = new Thread(() -> System.out.println("Hilo ejecutándose !"));
        hilo.start();

    }
}
