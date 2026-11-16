package edu.ingsoft.gof.comportamiento.visitor.problema;

/** DEUDA TÉCNICA: cada operación nueva se agrega en todas las subclases. */
public abstract class Articulo {
    protected final String nombre;
    protected final double precio;

    protected Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double impuesto();

    public abstract String aJson();
}
