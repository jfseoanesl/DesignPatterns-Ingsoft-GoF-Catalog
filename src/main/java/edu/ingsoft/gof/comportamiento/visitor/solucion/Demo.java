package edu.ingsoft.gof.comportamiento.visitor.solucion;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito(List.of(new Libro("Design Patterns", 180_000),
                new Electronico("Audífonos", 250_000), new Alimento("Café 500 g", 32_000)));
        carrito.recolectar(new VisitanteJson()).forEach(System.out::println);
        System.out.printf("IVA: $%,.0f | Envío: $%,.0f%n",
                carrito.sumar(new VisitanteIva()), carrito.sumar(new VisitanteEnvio()));
    }
}
