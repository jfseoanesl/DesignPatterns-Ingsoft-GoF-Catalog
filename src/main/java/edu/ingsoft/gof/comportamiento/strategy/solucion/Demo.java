package edu.ingsoft.gof.comportamiento.strategy.solucion;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, EstrategiaEnvio> modalidades = new LinkedHashMap<>();
        modalidades.put("estandar", new EnvioEstandar(3_000));
        modalidades.put("expres", new EnvioExpres(12_000, 4_500));
        modalidades.put("tienda", new RecogidaTienda());
        modalidades.put("internacional", new EnvioInternacional(18.5, 4_150));
        // Nueva modalidad sin modificar nada: gratis desde $150.000
        modalidades.put("verde", (kg, subtotal) -> subtotal >= 150_000 ? 0 : kg * 2_000);

        Carrito carrito = new Carrito(200_000, 2.5);
        modalidades.forEach((nombre, estrategia) -> {
            carrito.usarEnvio(estrategia);
            System.out.printf("%-14s total: $%,12.0f%n", nombre, carrito.total());
        });
    }
}
