import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploTres {

    public static void main(String[] args) {

        // Creamos un pool de hilos con un solo hilo (nO ES CONCURRENTE, SI NO NECESITAMOS MÁS HILOS)
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Programamos una tarea para que se ejecute repetidamente
        // Parámetros:
        // 1. Lambda que se ejecuta
        // 2. Delay inicial antes de la primera ejecución (0 segundos)
        // 3. Periodo entre ejecuciones (2 segundos)
        // 4. Unidad de tiempo
        executor.scheduleAtFixedRate(
                () -> System.out.println("Tarea repetitiva ejecutada"),
                0,
                2,
                TimeUnit.SECONDS
        );

        // En este ejemplo, no cerramos el executor automáticamente
        // para que siga ejecutando la tarea cada 2 segundos
        // Puedes agregar lógica para detenerlo después de cierto tiempo si quieres
    }
}
