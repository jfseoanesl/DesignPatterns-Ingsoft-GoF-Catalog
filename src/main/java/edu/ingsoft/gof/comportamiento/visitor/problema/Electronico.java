package edu.ingsoft.gof.comportamiento.visitor.problema;

public class Electronico extends Articulo {
    public Electronico(String n, double p) {
        super(n, p);
    }

    @Override
    public double impuesto() {
        return precio * 0.19;
    }

    @Override
    public String aJson() {
        return "{\"tipo\":\"electronico\",\"nombre\":\"" + nombre + "\"}";
    }
}
