package edu.ingsoft.gof.estructurales.composite.solucion;

/** Component: interfaz común para hojas y compuestos (sellada). */
public sealed interface UnidadOrganizacional permits Empleado, Departamento {
    String nombre();

    double costoMensual();

    void imprimir(StringBuilder sb, int nivel);
}
