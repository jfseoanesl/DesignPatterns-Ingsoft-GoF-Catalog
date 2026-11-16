package edu.ingsoft.gof.creacionales.singleton.ejemplos.dcl;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/** Compara una inicialización perezosa ingenua con double-checked locking. */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ingenua  -> instancias: " + probar(PoolIngenuo::getInstancia));
        System.out.println("DCL      -> instancias: " + probar(PoolDcl::getInstancia));
        System.out.println("(la versión ingenua puede crear más de una según la carrera)");
    }

    static int probar(java.util.function.Supplier<Object> acceso)
            throws InterruptedException {
        Set<Integer> ids = ConcurrentHashMap.newKeySet();
        CountDownLatch salida = new CountDownLatch(1);
        Thread[] hilos = new Thread[16];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                try {
                    salida.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                ids.add(System.identityHashCode(acceso.get()));
            });
            hilos[i].start();
        }
        salida.countDown(); // todos los hilos arrancan a la vez
        for (Thread h : hilos) {
            h.join();
        }
        return ids.size();
    }
}

final class PoolIngenuo {
    private static PoolIngenuo instancia;

    private PoolIngenuo() {
        dormir(); // constructor lento: amplía la ventana de carrera
    }

    static PoolIngenuo getInstancia() {
        if (instancia == null) { // dos hilos pueden pasar aquí a la vez
            instancia = new PoolIngenuo();
        }
        return instancia;
    }

    static void dormir() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

final class PoolDcl {
    private static volatile PoolDcl instancia; // volatile es obligatorio

    private PoolDcl() {
        PoolIngenuo.dormir();
    }

    static PoolDcl getInstancia() {
        PoolDcl local = instancia;
        if (local == null) {
            synchronized (PoolDcl.class) {
                local = instancia;
                if (local == null) {
                    instancia = local = new PoolDcl();
                }
            }
        }
        return local;
    }
}
