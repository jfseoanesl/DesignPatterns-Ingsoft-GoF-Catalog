package edu.ingsoft.gof.creacionales.singleton.ejemplos.enumeracion;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/** Enum de un solo elemento: seguro ante serialización y reflexión. */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    RegistroMetricas.INSTANCIA.incrementar("pedidos.creados");
                }
            });
            hilos[i].start();
        }
        for (Thread h : hilos) {
            h.join();
        }
        RegistroMetricas.INSTANCIA.incrementar("pagos.rechazados");
        System.out.println(RegistroMetricas.INSTANCIA.instantanea());
    }
}

enum RegistroMetricas {
    INSTANCIA;

    private final Map<String, LongAdder> contadores = new ConcurrentHashMap<>();

    void incrementar(String metrica) {
        contadores.computeIfAbsent(metrica, k -> new LongAdder()).increment();
    }

    Map<String, Long> instantanea() {
        Map<String, Long> copia = new TreeMap<>();
        contadores.forEach((k, v) -> copia.put(k, v.sum()));
        return copia;
    }
}
