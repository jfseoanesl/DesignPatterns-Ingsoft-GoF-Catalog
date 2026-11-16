package edu.ingsoft.gof.comportamiento.observer.problema;

public class PantallaActual {
    public void mostrar(double t, double h) {
        System.out.printf("  Pantalla: %.1f °C, %.0f%% humedad%n", t, h);
    }
}
