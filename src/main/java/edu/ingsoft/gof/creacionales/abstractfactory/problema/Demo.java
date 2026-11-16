package edu.ingsoft.gof.creacionales.abstractfactory.problema;

public class Demo {
    public static void main(String[] args) {
        System.out.println(new PantallaPago("oscuro").dibujar());
        System.out.println("--- tema mal escrito: \"Oscuro\" ---");
        System.out.println(new PantallaPago("Oscuro").dibujar());
    }
}
