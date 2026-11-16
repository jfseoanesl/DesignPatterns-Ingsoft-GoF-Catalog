package edu.ingsoft.gof.estructurales.decorator.ejemplos.servicios;

import java.util.HashMap;
import java.util.Map;

/** Preocupaciones transversales como decoradores de un servicio. */
public class Demo {
    public static void main(String[] args) {
        ServicioTasas servicio = new ConCache(new ConMedicion(new ConReintentos(
                new ServicioTasasRemoto(), 3)));
        System.out.println("USD->COP = " + servicio.tasa("USD", "COP"));
        System.out.println("USD->COP = " + servicio.tasa("USD", "COP") + " (desde caché)");
    }
}

interface ServicioTasas {
    double tasa(String origen, String destino);
}

/** Servicio inestable: falla las dos primeras llamadas. */
final class ServicioTasasRemoto implements ServicioTasas {
    private int llamadas;

    @Override
    public double tasa(String o, String d) {
        if (++llamadas < 3) {
            throw new IllegalStateException("timeout #" + llamadas);
        }
        return 4_150.25;
    }
}

final class ConReintentos implements ServicioTasas {
    private final ServicioTasas s;
    private final int max;

    ConReintentos(ServicioTasas s, int max) {
        this.s = s;
        this.max = max;
    }

    @Override
    public double tasa(String o, String d) {
        for (int i = 1; ; i++) {
            try {
                return s.tasa(o, d);
            } catch (IllegalStateException e) {
                System.out.println("  reintento " + i + " tras " + e.getMessage());
                if (i == max) {
                    throw e;
                }
            }
        }
    }
}

final class ConMedicion implements ServicioTasas {
    private final ServicioTasas s;

    ConMedicion(ServicioTasas s) {
        this.s = s;
    }

    @Override
    public double tasa(String o, String d) {
        long t0 = System.nanoTime();
        try {
            return s.tasa(o, d);
        } finally {
            System.out.println("  llamada medida (" + ((System.nanoTime() - t0) >= 0) + ")");
        }
    }
}

final class ConCache implements ServicioTasas {
    private final ServicioTasas s;
    private final Map<String, Double> cache = new HashMap<>();

    ConCache(ServicioTasas s) {
        this.s = s;
    }

    @Override
    public double tasa(String o, String d) {
        return cache.computeIfAbsent(o + "/" + d, k -> s.tasa(o, d));
    }
}
