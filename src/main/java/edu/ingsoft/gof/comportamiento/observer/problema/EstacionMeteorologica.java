package edu.ingsoft.gof.comportamiento.observer.problema;

/** DEUDA TÉCNICA: el sujeto conoce a cada vista concreta. */
public class EstacionMeteorologica {
    private final PantallaActual pantalla = new PantallaActual();
    private final PanelEstadisticas estadisticas = new PanelEstadisticas();
    private final AlertaCalor alerta = new AlertaCalor();

    public void registrar(double temp, double humedad) {
        System.out.println("Medición: " + temp);
        pantalla.mostrar(temp, humedad);
        estadisticas.actualizar(temp);
        alerta.revisar(temp);
        // ¿Enviar a la nube? Hay que modificar esta clase.
    }
}
