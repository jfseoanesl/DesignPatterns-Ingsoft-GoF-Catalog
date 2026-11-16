package edu.ingsoft.gof.estructurales.composite.solucion;

/** Client: trata igual a un empleado y a toda la empresa. */
public class ServicioNomina {

    public String reporte(UnidadOrganizacional u) {
        StringBuilder sb = new StringBuilder();
        u.imprimir(sb, 0);
        sb.append(String.format("Costo mensual de %s: $%,.0f", u.nombre(), u.costoMensual()));
        return sb.toString();
    }
}
