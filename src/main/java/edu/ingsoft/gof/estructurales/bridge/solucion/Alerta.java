package edu.ingsoft.gof.estructurales.bridge.solucion;

public class Alerta extends Mensaje {
    public Alerta(CanalEnvio canal) {
        super(canal);
    }

    @Override
    protected String formatear(String texto) {
        return "⚠ ALERTA: " + texto.toUpperCase();
    }
}
