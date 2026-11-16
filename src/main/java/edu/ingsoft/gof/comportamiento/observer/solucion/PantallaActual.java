package edu.ingsoft.gof.comportamiento.observer.solucion;

public class PantallaActual implements ObservadorClima {
    @Override
    public void actualizar(Medicion m) {
        System.out.printf("  Pantalla: %.1f °C, %.0f%% humedad%n", m.temperatura(), m.humedad());
    }
}
