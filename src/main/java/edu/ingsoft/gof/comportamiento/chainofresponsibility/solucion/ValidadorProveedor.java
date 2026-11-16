package edu.ingsoft.gof.comportamiento.chainofresponsibility.solucion;

import java.util.Set;

/** Eslabón que puede detener la cadena. */
public class ValidadorProveedor extends Aprobador {
    private final Set<String> bloqueados;

    public ValidadorProveedor(Set<String> bloqueados) {
        this.bloqueados = Set.copyOf(bloqueados);
    }

    @Override
    protected boolean puedeResolver(SolicitudCompra s) {
        return bloqueados.contains(s.proveedor());
    }

    @Override
    protected String resolver(SolicitudCompra s) {
        return "Rechazada: proveedor bloqueado";
    }
}
