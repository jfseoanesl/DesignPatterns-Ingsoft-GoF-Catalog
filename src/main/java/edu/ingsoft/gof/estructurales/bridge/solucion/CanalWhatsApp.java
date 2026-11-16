package edu.ingsoft.gof.estructurales.bridge.solucion;

/** Nuevo canal: una sola clase, sirve para todos los tipos de mensaje. */
public class CanalWhatsApp implements CanalEnvio {
    @Override
    public String entregar(String destino, String contenido) {
        return "WA-API -> " + destino + " | " + contenido;
    }
}
