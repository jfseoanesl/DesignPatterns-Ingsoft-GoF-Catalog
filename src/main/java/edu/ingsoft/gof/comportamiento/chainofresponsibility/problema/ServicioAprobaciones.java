package edu.ingsoft.gof.comportamiento.chainofresponsibility.problema;

import java.util.Set;

/** DEUDA TÉCNICA: toda la política de aprobación en un solo condicional. */
public class ServicioAprobaciones {
    private final Set<String> proveedoresBloqueados = Set.of("ACME-FRAUDE");

    public String aprobar(SolicitudCompra s) {
        if (proveedoresBloqueados.contains(s.proveedor())) {
            return "Rechazada: proveedor bloqueado";
        }
        if (s.monto() <= 1_000_000) {
            return "Aprobada por Supervisor";
        } else if (s.monto() <= 10_000_000) {
            return "Aprobada por Gerente";
        } else if (s.monto() <= 50_000_000) {
            return "Aprobada por Director";
        } else {
            return "Enviada a Comité";
        }
        // ¿Nuevo nivel "Vicepresidente" entre Director y Comité? Editar aquí...
    }
}
