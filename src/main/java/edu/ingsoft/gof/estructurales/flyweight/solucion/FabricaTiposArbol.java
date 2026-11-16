package edu.ingsoft.gof.estructurales.flyweight.solucion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** FlyweightFactory: garantiza una sola instancia por especie. */
public class FabricaTiposArbol {
    private final Map<String, TipoArbol> tipos = new ConcurrentHashMap<>();

    public TipoArbol obtener(String especie, String color) {
        return tipos.computeIfAbsent(especie + "|" + color,
                k -> new TipoArbol(especie, color, new byte[2048]));
    }

    public int cantidad() {
        return tipos.size();
    }

    public long bytesTexturas() {
        return tipos.values().stream().mapToLong(t -> t.textura().length).sum();
    }
}
