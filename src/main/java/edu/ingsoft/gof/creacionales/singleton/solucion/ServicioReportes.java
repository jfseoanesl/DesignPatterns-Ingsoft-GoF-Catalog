package edu.ingsoft.gof.creacionales.singleton.solucion;

public class ServicioReportes {
    public String origen() {
        return Configuracion.getInstancia().urlBaseDatos();
    }
}
