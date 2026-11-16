package edu.ingsoft.gof.comportamiento.strategy.solucion;

public class RecogidaTienda implements EstrategiaEnvio {
    @Override
    public double costo(double pesoKg, double subtotal) {
        return 0;
    }
}
