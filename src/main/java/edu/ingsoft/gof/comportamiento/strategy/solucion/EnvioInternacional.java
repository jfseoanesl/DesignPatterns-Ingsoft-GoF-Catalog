package edu.ingsoft.gof.comportamiento.strategy.solucion;

public class EnvioInternacional implements EstrategiaEnvio {
    private final double usdPorKg;
    private final double tasaCambio;

    public EnvioInternacional(double usdPorKg, double tasaCambio) {
        this.usdPorKg = usdPorKg;
        this.tasaCambio = tasaCambio;
    }

    @Override
    public double costo(double pesoKg, double subtotal) {
        return pesoKg * usdPorKg * tasaCambio;
    }
}
