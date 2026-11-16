package edu.ingsoft.gof.creacionales.builder.problema;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String[]> filas = List.of(new String[] {"Teclado", "120000"},
                                       new String[] {"Monitor", "890000"});
        GeneradorReporte g = new GeneradorReporte();
        System.out.println(g.generar("html", "Ventas", filas, "Total: 1010000"));
        System.out.println(g.generar("texto", "Ventas", filas, "Total: 1010000"));
        System.out.println("[markdown] -> '" + g.generar("md", "Ventas", filas, null) + "'");
    }
}
