package edu.ingsoft.gof.comportamiento.visitor.solucion;

/** Operación nueva: no se modificó ninguna clase de producto. */
public class VisitanteEnvio implements Visitante<Double> {
    @Override
    public Double visitar(Libro l) {
        return 5_000.0;
    }

    @Override
    public Double visitar(Electronico e) {
        return 15_000.0;
    }

    @Override
    public Double visitar(Alimento a) {
        return 8_000.0;
    }
}
