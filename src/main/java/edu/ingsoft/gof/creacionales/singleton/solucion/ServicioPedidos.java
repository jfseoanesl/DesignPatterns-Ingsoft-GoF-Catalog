package edu.ingsoft.gof.creacionales.singleton.solucion;

public class ServicioPedidos {
    public int conexiones() {
        return Configuracion.getInstancia().maxConexiones();
    }
}
