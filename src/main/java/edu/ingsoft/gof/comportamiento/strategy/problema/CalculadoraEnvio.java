package edu.ingsoft.gof.comportamiento.strategy.problema;

/** DEUDA TÉCNICA: todas las fórmulas en un switch. */
public class CalculadoraEnvio {

    public double costo(double pesoKg, String modalidad) {
        switch (modalidad) {
            case "estandar":
                return pesoKg * 3_000;
            case "expres":
                return 12_000 + pesoKg * 4_500;
            case "tienda":
                return 0;
            case "internacional":
                double usd = pesoKg * 18.5;
                return usd * 4_150; // tasa de cambio fija en el código
            default:
                throw new IllegalArgumentException("Modalidad desconocida: " + modalidad);
        }
    }
}
