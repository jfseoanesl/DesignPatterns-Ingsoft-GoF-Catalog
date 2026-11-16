package edu.ingsoft.gof.creacionales.singleton.problema;

public class ServicioReportes {
    private final Configuracion cfg = new Configuracion();

    public int conexiones() {
        return cfg.maxConexiones;
    }
}
