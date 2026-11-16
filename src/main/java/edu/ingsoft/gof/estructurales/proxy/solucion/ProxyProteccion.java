package edu.ingsoft.gof.estructurales.proxy.solucion;

/** Proxy de protección. */
public class ProxyProteccion implements ServicioReportes {
    private final ServicioReportes destino;
    private final String rolRequerido;

    public ProxyProteccion(ServicioReportes destino, String rolRequerido) {
        this.destino = destino;
        this.rolRequerido = rolRequerido;
    }

    @Override
    public String consolidado(Usuario usuario, String periodo) {
        if (!rolRequerido.equals(usuario.rol())) {
            throw new SecurityException("Acceso denegado a " + usuario.nombre());
        }
        return destino.consolidado(usuario, periodo);
    }
}
