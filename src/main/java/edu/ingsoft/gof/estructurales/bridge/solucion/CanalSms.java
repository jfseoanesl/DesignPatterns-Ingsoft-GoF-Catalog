package edu.ingsoft.gof.estructurales.bridge.solucion;

public class CanalSms implements CanalEnvio {
    private static final int MAX = 30;

    @Override
    public String entregar(String destino, String contenido) {
        String corto = contenido.length() > MAX ? contenido.substring(0, MAX) : contenido;
        return "SMS-GW -> " + destino + " | " + corto;
    }
}
