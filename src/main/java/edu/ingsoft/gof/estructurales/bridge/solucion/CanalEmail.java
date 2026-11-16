package edu.ingsoft.gof.estructurales.bridge.solucion;

public class CanalEmail implements CanalEnvio {
    @Override
    public String entregar(String destino, String contenido) {
        return "SMTP -> " + destino + " | " + contenido;
    }
}
