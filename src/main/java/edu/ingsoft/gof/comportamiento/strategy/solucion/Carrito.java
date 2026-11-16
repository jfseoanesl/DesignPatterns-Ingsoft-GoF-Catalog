package edu.ingsoft.gof.comportamiento.strategy.solucion;

import java.util.Objects;

/** Context. */
public class Carrito {
    private final double subtotal;
    private final double pesoKg;
    private EstrategiaEnvio estrategia = new RecogidaTienda(); // por defecto

    public Carrito(double subtotal, double pesoKg) {
        this.subtotal = subtotal;
        this.pesoKg = pesoKg;
    }

    public void usarEnvio(EstrategiaEnvio e) {
        this.estrategia = Objects.requireNonNull(e);
    }

    public double total() {
        return subtotal + estrategia.costo(pesoKg, subtotal);
    }
}
