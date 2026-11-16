package edu.ingsoft.gof.estructurales.composite.solucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Composite. */
public final class Departamento implements UnidadOrganizacional {
    private final String nombre;
    private final List<UnidadOrganizacional> miembros = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento agregar(UnidadOrganizacional u) {
        if (u == this) {
            throw new IllegalArgumentException("Un departamento no puede contenerse");
        }
        miembros.add(u);
        return this;
    }

    public List<UnidadOrganizacional> miembros() {
        return Collections.unmodifiableList(miembros);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public double costoMensual() {
        return miembros.stream().mapToDouble(UnidadOrganizacional::costoMensual).sum();
    }

    @Override
    public void imprimir(StringBuilder sb, int nivel) {
        sb.append("  ".repeat(nivel)).append("+ ").append(nombre).append('\n');
        miembros.forEach(m -> m.imprimir(sb, nivel + 1));
    }
}
