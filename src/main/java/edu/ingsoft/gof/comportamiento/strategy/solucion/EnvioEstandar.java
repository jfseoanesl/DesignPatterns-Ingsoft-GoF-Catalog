package edu.ingsoft.gof.comportamiento.strategy.solucion;

public class EnvioEstandar implements EstrategiaEnvio {
    private final double tarifaKg;

    public EnvioEstandar(double tarifaKg) {
        this.tarifaKg = tarifaKg;
    }

    @Override
    public double costo(double pesoKg, double subtotal) {
        return pesoKg * tarifaKg;
    }
}
