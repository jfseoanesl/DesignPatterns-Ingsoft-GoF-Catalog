package edu.ingsoft.gof.comportamiento.visitor.solucion;

public record Libro(String nombre, double precio) implements Articulo {
    @Override
    public <R> R aceptar(Visitante<R> v) {
        return v.visitar(this); // doble despacho
    }
}
