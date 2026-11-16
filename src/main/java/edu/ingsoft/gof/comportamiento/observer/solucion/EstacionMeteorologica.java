package edu.ingsoft.gof.comportamiento.observer.solucion;

/** ConcreteSubject: publica mediciones sin saber quién escucha. */
public class EstacionMeteorologica extends Sujeto<Medicion> {

    public void registrar(double temp, double humedad) {
        System.out.println("Medición: " + temp);
        notificar(new Medicion(temp, humedad));
    }
}
