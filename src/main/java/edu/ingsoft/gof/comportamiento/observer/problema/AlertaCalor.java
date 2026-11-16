package edu.ingsoft.gof.comportamiento.observer.problema;

public class AlertaCalor {
    public void revisar(double t) {
        if (t > 32) {
            System.out.println("  ALERTA: calor extremo");
        }
    }
}
