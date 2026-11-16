package edu.ingsoft.gof.comportamiento.observer.solucion;

public class PanelEstadisticas implements ObservadorClima {
    private double suma;
    private int n;

    @Override
    public void actualizar(Medicion m) {
        suma += m.temperatura();
        n++;
        System.out.printf("  Estadísticas: promedio %.1f °C%n", suma / n);
    }
}
