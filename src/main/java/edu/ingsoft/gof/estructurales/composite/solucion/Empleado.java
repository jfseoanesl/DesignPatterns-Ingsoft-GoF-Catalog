package edu.ingsoft.gof.estructurales.composite.solucion;

/** Leaf. */
public record Empleado(String nombre, String cargo, double salario)
        implements UnidadOrganizacional {

    @Override
    public double costoMensual() {
        return salario;
    }

    @Override
    public void imprimir(StringBuilder sb, int nivel) {
        sb.append("  ".repeat(nivel)).append("- ").append(nombre)
          .append(" (").append(cargo).append(")\n");
    }
}
