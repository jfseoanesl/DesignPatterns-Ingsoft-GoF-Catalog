package edu.ingsoft.gof.comportamiento.templatemethod.solucion;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String csv = "# sku,precio\nA1,1500\nA2,-30\nA3,800";
        String json = "[{\"sku\":\"A1\",\"precio\":1500},{\"sku\":\"A2\",\"precio\":-30},"
                + "{\"sku\":\"A3\",\"precio\":800}]";
        List<ImportadorProductos> importadores = List.of(new ImportadorCsv(),
                new ImportadorJson());
        System.out.println(importadores.get(0).importar(csv));
        System.out.println(importadores.get(1).importar(json) + "   <- consistente");
    }
}
