package edu.ingsoft.gof.comportamiento.strategy.solucion;

/** Strategy (interfaz funcional). */
@FunctionalInterface
public interface EstrategiaEnvio {
    double costo(double pesoKg, double subtotal);
}
