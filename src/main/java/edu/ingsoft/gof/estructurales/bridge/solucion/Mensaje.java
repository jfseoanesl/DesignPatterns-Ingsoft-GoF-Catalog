package edu.ingsoft.gof.estructurales.bridge.solucion;

import java.util.Objects;

/** Abstraction: delega el transporte en el puente. */
public abstract class Mensaje {
    protected final CanalEnvio canal;

    protected Mensaje(CanalEnvio canal) {
        this.canal = Objects.requireNonNull(canal);
    }

    public String enviar(String destino, String texto) {
        return canal.entregar(destino, formatear(texto));
    }

    protected abstract String formatear(String texto);
}
