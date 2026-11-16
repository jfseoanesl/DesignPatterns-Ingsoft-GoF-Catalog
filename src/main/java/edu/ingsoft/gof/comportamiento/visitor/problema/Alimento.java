package edu.ingsoft.gof.comportamiento.visitor.problema;

public class Alimento extends Articulo {
    public Alimento(String n, double p) {
        super(n, p);
    }

    @Override
    public double impuesto() {
        return precio * 0.05;
    }

    @Override
    public String aJson() {
        return "{\"tipo\":\"alimento\",\"nombre\":\"" + nombre + "\"}";
    }
}
