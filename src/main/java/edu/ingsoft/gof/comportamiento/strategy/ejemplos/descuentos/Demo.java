package edu.ingsoft.gof.comportamiento.strategy.ejemplos.descuentos;

import java.util.List;
import java.util.function.UnaryOperator;

/** Estrategias funcionales de descuento que se componen. */
public class Demo {
    public static void main(String[] args) {
        UnaryOperator<Double> sinDescuento = p -> p;
        UnaryOperator<Double> blackFriday = p -> p * 0.70;
        UnaryOperator<Double> clienteFrecuente = p -> p - 10_000;
        UnaryOperator<Double> minimoCero = p -> Math.max(0, p);

        List<Descuento> politicas = List.of(
                new Descuento("Ninguno", sinDescuento),
                new Descuento("Black Friday", blackFriday),
                new Descuento("BF + frecuente", componer(blackFriday, clienteFrecuente, minimoCero)));

        double precio = 120_000;
        for (Descuento d : politicas) {
            System.out.printf("%-16s $%,10.0f%n", d.nombre(), d.regla().apply(precio));
        }
    }

    @SafeVarargs
    static UnaryOperator<Double> componer(UnaryOperator<Double>... pasos) {
        return p -> {
            double r = p;
            for (UnaryOperator<Double> paso : pasos) {
                r = paso.apply(r);
            }
            return r;
        };
    }
}

record Descuento(String nombre, UnaryOperator<Double> regla) {
}
