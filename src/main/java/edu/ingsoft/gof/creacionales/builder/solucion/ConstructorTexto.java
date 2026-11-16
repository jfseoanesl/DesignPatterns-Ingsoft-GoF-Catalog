package edu.ingsoft.gof.creacionales.builder.solucion;

import java.util.ArrayList;
import java.util.List;

/** ConcreteBuilder: representación en texto plano. */
public class ConstructorTexto implements ConstructorReporte {
    private final List<String> lineas = new ArrayList<>();

    @Override
    public void titulo(String texto) {
        lineas.add(texto.toUpperCase());
        lineas.add("=".repeat(texto.length()));
    }

    @Override
    public void fila(String producto, double total) {
        lineas.add(String.format("%-12s %10.0f", producto, total));
    }

    @Override
    public void pie(String texto) {
        lineas.add("-".repeat(23));
        lineas.add(texto);
    }

    public String resultado() {
        return String.join("\n", lineas);
    }
}
