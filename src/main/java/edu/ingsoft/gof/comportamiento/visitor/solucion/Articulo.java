package edu.ingsoft.gof.comportamiento.visitor.solucion;

/** Element: jerarquía estable y sellada. */
public sealed interface Articulo permits Libro, Electronico, Alimento {
    String nombre();

    double precio();

    <R> R aceptar(Visitante<R> v);
}
