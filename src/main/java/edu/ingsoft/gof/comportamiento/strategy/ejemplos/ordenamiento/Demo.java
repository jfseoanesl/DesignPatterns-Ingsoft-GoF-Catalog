package edu.ingsoft.gof.comportamiento.strategy.ejemplos.ordenamiento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Comparator es una estrategia de ordenamiento del JDK. */
public class Demo {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>(List.of(
                new Producto("Teclado", 120_000, 4.5),
                new Producto("Mouse", 60_000, 4.8),
                new Producto("Monitor", 890_000, 4.5),
                new Producto("Audífonos", 120_000, 4.2)));

        imprimir("Por precio", productos, Comparator.comparingDouble(Producto::precio));
        imprimir("Mejor valorados, luego más baratos", productos,
                Comparator.comparingDouble(Producto::valoracion).reversed()
                        .thenComparingDouble(Producto::precio));
        imprimir("Alfabético", productos, Comparator.comparing(Producto::nombre));
    }

    static void imprimir(String titulo, List<Producto> lista, Comparator<Producto> estrategia) {
        List<Producto> copia = new ArrayList<>(lista);
        copia.sort(estrategia);
        System.out.println(titulo + ": " + copia.stream().map(Producto::nombre).toList());
    }
}

record Producto(String nombre, double precio, double valoracion) {
}
