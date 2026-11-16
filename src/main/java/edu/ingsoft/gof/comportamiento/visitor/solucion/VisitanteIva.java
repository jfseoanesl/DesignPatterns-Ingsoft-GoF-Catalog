package edu.ingsoft.gof.comportamiento.visitor.solucion;

/** Toda la regla fiscal en un solo lugar. */
public class VisitanteIva implements Visitante<Double> {
    @Override
    public Double visitar(Libro l) {
        return 0.0; // exento
    }

    @Override
    public Double visitar(Electronico e) {
        return e.precio() * 0.19;
    }

    @Override
    public Double visitar(Alimento a) {
        return a.precio() * 0.05;
    }
}
