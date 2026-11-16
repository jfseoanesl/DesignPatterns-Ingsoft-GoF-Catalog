package edu.ingsoft.gof.comportamiento.visitor.solucion;

import java.util.List;

/** ObjectStructure. */
public class Carrito {
    private final List<Articulo> articulos;

    public Carrito(List<Articulo> articulos) {
        this.articulos = List.copyOf(articulos);
    }

    public double sumar(Visitante<Double> v) {
        return articulos.stream().mapToDouble(a -> a.aceptar(v)).sum();
    }

    public List<String> recolectar(Visitante<String> v) {
        return articulos.stream().map(a -> a.aceptar(v)).toList();
    }
}
