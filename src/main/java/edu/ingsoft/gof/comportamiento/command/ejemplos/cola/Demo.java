package edu.ingsoft.gof.comportamiento.command.ejemplos.cola;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/** Comandos como trabajos encolados en un ExecutorService con reintentos. */
public class Demo {
    public static void main(String[] args) throws Exception {
        ExecutorService cola = Executors.newSingleThreadExecutor();
        AtomicInteger intentos = new AtomicInteger();
        Trabajo enviarCorreo = () -> {
            if (intentos.incrementAndGet() < 3) {
                throw new IllegalStateException("SMTP no disponible");
            }
            return "correo enviado en el intento " + intentos.get();
        };
        Future<String> r = cola.submit(new ConReintentos(enviarCorreo, 5));
        System.out.println(r.get());
        cola.shutdown();
    }
}

@FunctionalInterface
interface Trabajo {
    String ejecutar() throws Exception;
}

/** Comando que envuelve a otro y lo reintenta: también es un Callable. */
final class ConReintentos implements java.util.concurrent.Callable<String> {
    private final Trabajo trabajo;
    private final int maximo;

    ConReintentos(Trabajo t, int maximo) {
        this.trabajo = t;
        this.maximo = maximo;
    }

    @Override
    public String call() throws Exception {
        for (int i = 1; ; i++) {
            try {
                return trabajo.ejecutar();
            } catch (Exception e) {
                System.out.println("  intento " + i + " falló: " + e.getMessage());
                if (i == maximo) {
                    throw e;
                }
            }
        }
    }
}
