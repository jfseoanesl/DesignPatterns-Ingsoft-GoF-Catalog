package edu.ingsoft.gof.comportamiento.chainofresponsibility.solucion;

/** Eslabón terminal: garantiza que toda solicitud tenga respuesta. */
public class Comite extends Aprobador {
    @Override
    protected boolean puedeResolver(SolicitudCompra s) {
        return true;
    }

    @Override
    protected String resolver(SolicitudCompra s) {
        return "Enviada a Comité";
    }
}
