package edu.ingsoft.gof.comportamiento.strategy.problema;

public class Carrito {
    private final double subtotal;
    private final double pesoKg;
    private final String modalidad;
    private final CalculadoraEnvio calculadora = new CalculadoraEnvio();

    public Carrito(double subtotal, double pesoKg, String modalidad) {
        this.subtotal = subtotal;
        this.pesoKg = pesoKg;
        this.modalidad = modalidad;
    }

    public double total() {
        return subtotal + calculadora.costo(pesoKg, modalidad);
    }
}
