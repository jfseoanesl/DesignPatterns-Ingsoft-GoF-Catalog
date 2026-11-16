package edu.ingsoft.gof.creacionales.builder.solucion;

import java.util.List;

/** Director: conoce el orden de construcción, no el formato. */
public class DirectorReporteVentas {

    public void construir(ConstructorReporte b, String titulo, List<Venta> ventas) {
        b.titulo(titulo);
        double total = 0;
        for (Venta v : ventas) {
            b.fila(v.producto(), v.total());
            total += v.total();
        }
        b.pie(String.format("Total: %.0f", total));
    }
}
