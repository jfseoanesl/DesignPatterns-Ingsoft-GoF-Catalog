package edu.ingsoft.gof.estructurales.bridge.solucion;

import java.time.LocalDate;

public class Recordatorio extends Mensaje {
    private final LocalDate fecha;

    public Recordatorio(CanalEnvio canal, LocalDate fecha) {
        super(canal);
        this.fecha = fecha;
    }

    @Override
    protected String formatear(String texto) {
        return "Recordatorio (" + fecha + "): " + texto;
    }
}
