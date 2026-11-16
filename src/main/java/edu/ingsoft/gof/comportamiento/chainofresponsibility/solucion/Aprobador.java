package edu.ingsoft.gof.comportamiento.chainofresponsibility.solucion;

/** Handler base: plantilla de «resolver o pasar al siguiente». */
public abstract class Aprobador {
    private Aprobador siguiente;

    /** Construye la cadena en el orden recibido y devuelve el primer eslabón. */
    public static Aprobador cadena(Aprobador... eslabones) {
        for (int i = 0; i < eslabones.length - 1; i++) {
            eslabones[i].siguiente = eslabones[i + 1];
        }
        return eslabones[0];
    }

    public final String manejar(SolicitudCompra s) {
        if (puedeResolver(s)) {
            return resolver(s);
        }
        if (siguiente == null) {
            return "Sin aprobador disponible";
        }
        return siguiente.manejar(s);
    }

    protected abstract boolean puedeResolver(SolicitudCompra s);

    protected abstract String resolver(SolicitudCompra s);
}
