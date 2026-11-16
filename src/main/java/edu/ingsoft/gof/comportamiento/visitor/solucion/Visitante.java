package edu.ingsoft.gof.comportamiento.visitor.solucion;

/** Visitor genérico: una operación visitar por cada tipo de elemento. */
public interface Visitante<R> {
    R visitar(Libro libro);

    R visitar(Electronico electronico);

    R visitar(Alimento alimento);
}
