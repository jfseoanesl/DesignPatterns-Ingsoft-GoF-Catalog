package edu.ingsoft.gof.comportamiento.observer.problema;

public class PanelEstadisticas {
    private double suma;
    private int n;

    public void actualizar(double t) {
        suma += t;
        n++;
        System.out.printf("  Estadísticas: promedio %.1f °C%n", suma / n);
    }
}
