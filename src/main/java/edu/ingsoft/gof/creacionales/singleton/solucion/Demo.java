package edu.ingsoft.gof.creacionales.singleton.solucion;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> identidades = ConcurrentHashMap.newKeySet();
        ExecutorService pool = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 8; i++) {
            pool.submit(() -> identidades.add(
                    System.identityHashCode(Configuracion.getInstancia())));
        }
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Instancias distintas vistas por 8 hilos: " + identidades.size());
        System.out.println("Cargas del archivo: " + Configuracion.cargas());
        System.out.println("Pedidos: " + new ServicioPedidos().conexiones()
                + " conexiones | Reportes: " + new ServicioReportes().origen());
    }
}
