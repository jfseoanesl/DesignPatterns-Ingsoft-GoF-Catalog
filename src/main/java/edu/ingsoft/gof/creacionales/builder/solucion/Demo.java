package edu.ingsoft.gof.creacionales.builder.solucion;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Venta> ventas = List.of(new Venta("Teclado", 120_000),
                                     new Venta("Monitor", 890_000));
        DirectorReporteVentas director = new DirectorReporteVentas();

        ConstructorHtml html = new ConstructorHtml();
        director.construir(html, "Ventas", ventas);
        System.out.println(html.resultado());

        ConstructorTexto texto = new ConstructorTexto();
        director.construir(texto, "Ventas", ventas);
        System.out.println(texto.resultado());
    }
}
