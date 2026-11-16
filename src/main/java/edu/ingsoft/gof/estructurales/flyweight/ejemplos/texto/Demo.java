package edu.ingsoft.gof.estructurales.flyweight.ejemplos.texto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Glifos compartidos en un editor de texto. */
public class Demo {
    public static void main(String[] args) {
        FabricaGlifos fabrica = new FabricaGlifos();
        List<CaracterPosicionado> doc = new ArrayList<>();
        String texto = "patrones de diseño patrones de diseño";
        for (int i = 0; i < texto.length(); i++) {
            doc.add(new CaracterPosicionado(i, 0, fabrica.glifo(texto.charAt(i), "Serif-12")));
        }
        System.out.println("Caracteres: " + doc.size() + " | glifos distintos: "
                + fabrica.cantidad());
        System.out.println("Render del 1er carácter: " + doc.get(0).render());
    }
}

record Glifo(char simbolo, String fuente) {
    String render(int columna, int fila) {
        return "'" + simbolo + "' " + fuente + " @(" + columna + "," + fila + ")";
    }
}

record CaracterPosicionado(int columna, int fila, Glifo glifo) {
    String render() {
        return glifo.render(columna, fila);
    }
}

final class FabricaGlifos {
    private final Map<String, Glifo> cache = new HashMap<>();

    Glifo glifo(char c, String fuente) {
        return cache.computeIfAbsent(c + fuente, k -> new Glifo(c, fuente));
    }

    int cantidad() {
        return cache.size();
    }
}
