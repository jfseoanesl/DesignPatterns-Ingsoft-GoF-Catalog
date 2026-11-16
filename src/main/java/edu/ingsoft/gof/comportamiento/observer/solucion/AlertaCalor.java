package edu.ingsoft.gof.comportamiento.observer.solucion;

public class AlertaCalor implements ObservadorClima {
    private final double umbral;

    public AlertaCalor(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void actualizar(Medicion m) {
        if (m.temperatura() > umbral) {
            System.out.println("  ALERTA: calor extremo");
        }
    }
}
