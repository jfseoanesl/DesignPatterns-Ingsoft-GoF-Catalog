package edu.ingsoft.gof.comportamiento.strategy.solucion;

public class EnvioExpres implements EstrategiaEnvio {
    private final double base;
    private final double recargoKg;

    public EnvioExpres(double base, double recargoKg) {
        this.base = base;
        this.recargoKg = recargoKg;
    }

    @Override
    public double costo(double pesoKg, double subtotal) {
        return base + pesoKg * recargoKg;
    }
}
