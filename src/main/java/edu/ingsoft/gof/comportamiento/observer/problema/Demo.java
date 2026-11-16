package edu.ingsoft.gof.comportamiento.observer.problema;

public class Demo {
    public static void main(String[] args) {
        EstacionMeteorologica e = new EstacionMeteorologica();
        e.registrar(28.5, 70);
        e.registrar(33.0, 55);
    }
}
