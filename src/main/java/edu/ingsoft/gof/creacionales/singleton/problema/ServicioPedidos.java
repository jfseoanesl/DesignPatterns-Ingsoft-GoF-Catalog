package edu.ingsoft.gof.creacionales.singleton.problema;

public class ServicioPedidos {
    private final Configuracion cfg = new Configuracion();

    public void ajustarParaTemporadaAlta() {
        cfg.maxConexiones = 50; // solo cambia SU copia
    }

    public int conexiones() {
        return cfg.maxConexiones;
    }
}
