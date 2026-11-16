package edu.ingsoft.gof.comportamiento.visitor.problema;

public class Libro extends Articulo {
    public Libro(String n, double p) {
        super(n, p);
    }

    @Override
    public double impuesto() {
        return 0; // regla fiscal dentro del dominio
    }

    @Override
    public String aJson() {
        return "{\"tipo\":\"libro\",\"nombre\":\"" + nombre + "\"}";
    }
}
