package edu.ingsoft.gof.creacionales.singleton.solucion;

import java.util.concurrent.atomic.AtomicInteger;

/** Singleton con el idioma Holder: perezoso, thread-safe y sin locks. */
public final class Configuracion {
    private static final AtomicInteger CARGAS = new AtomicInteger();

    private final String urlBaseDatos;
    private final int maxConexiones;

    private Configuracion() {
        CARGAS.incrementAndGet(); // simula la lectura de app.properties
        this.urlBaseDatos = "jdbc:postgresql://db:5432/tienda";
        this.maxConexiones = 10;
    }

    /** La JVM inicializa Holder solo al primer acceso y de forma atómica. */
    private static final class Holder {
        static final Configuracion INSTANCIA = new Configuracion();
    }

    public static Configuracion getInstancia() {
        return Holder.INSTANCIA;
    }

    public String urlBaseDatos() {
        return urlBaseDatos;
    }

    public int maxConexiones() {
        return maxConexiones;
    }

    static int cargas() {
        return CARGAS.get();
    }
}
