package edu.ingsoft.gof.comportamiento.visitor.problema;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Articulo> carrito = List.of(new Libro("Design Patterns", 180_000),
                new Electronico("Audífonos", 250_000), new Alimento("Café 500 g", 32_000));
        double iva = 0;
        double envio = 0;
        Reporte r = new Reporte();
        for (Articulo a : carrito) {
            iva += a.impuesto();
            envio += r.costoEnvio(a);
            System.out.println(a.aJson());
        }
        System.out.printf("IVA: $%,.0f | Envío: $%,.0f%n", iva, envio);
    }
}
