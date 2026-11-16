package edu.ingsoft.gof.estructurales.facade.problema;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private final Map<String, Integer> stock = new HashMap<>(Map.of("SKU-1", 5));

    public boolean reservar(String sku, int cantidad) {
        int disp = stock.getOrDefault(sku, 0);
        if (disp < cantidad) {
            return false;
        }
        stock.put(sku, disp - cantidad);
        return true;
    }

    public void liberar(String sku, int cantidad) {
        stock.merge(sku, cantidad, Integer::sum);
    }

    public int disponible(String sku) {
        return stock.getOrDefault(sku, 0);
    }
}
