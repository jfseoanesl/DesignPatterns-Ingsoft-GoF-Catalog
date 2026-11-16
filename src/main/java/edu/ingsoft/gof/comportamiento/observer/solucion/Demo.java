package edu.ingsoft.gof.comportamiento.observer.solucion;

public class Demo {
    public static void main(String[] args) {
        EstacionMeteorologica estacion = new EstacionMeteorologica();
        PantallaActual pantalla = new PantallaActual();
        estacion.suscribir(pantalla);
        estacion.suscribir(new PanelEstadisticas());
        estacion.suscribir(new AlertaCalor(32));
        // Nuevo observador sin modificar la estación (lambda):
        ObservadorClima nube = m -> System.out.println("  Nube <- " + m);
        estacion.suscribir(nube);

        estacion.registrar(28.5, 70);
        estacion.desuscribir(pantalla);
        estacion.desuscribir(nube);
        estacion.registrar(33.0, 55);
    }
}
