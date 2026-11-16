package edu.ingsoft.gof.estructurales.proxy.solucion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/** Proxy virtual + caché: crea el sujeto real solo cuando hace falta. */
public class ProxyCache implements ServicioReportes {
    private final Supplier<ServicioReportes> fabrica;
    private final Map<String, String> cache = new ConcurrentHashMap<>();
    private ServicioReportes real;

    public ProxyCache(Supplier<ServicioReportes> fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public String consolidado(Usuario usuario, String periodo) {
        return cache.computeIfAbsent(periodo, p -> real().consolidado(usuario, p));
    }

    private synchronized ServicioReportes real() {
        if (real == null) {
            real = fabrica.get();
        }
        return real;
    }
}
