package edu.ingsoft.gof.creacionales.factorymethod.ejemplos.exportadores;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Creator concreto con un producto por defecto que las subclases pueden redefinir. */
public class Demo {
    public static void main(String[] args) {
        List<Map<String, Object>> datos = List.of(
                Map.of("id", 1, "nombre", "Ana"),
                Map.of("id", 2, "nombre", "Luis"));
        System.out.println(new Exportador().exportar(datos));
        System.out.println(new ExportadorJson().exportar(datos));
    }
}

interface Formateador {
    String formatear(Map<String, Object> fila);
}

class Exportador {
    /** Template que usa el Factory Method. */
    final String exportar(List<Map<String, Object>> filas) {
        Formateador f = crearFormateador();
        return filas.stream().map(f::formatear).collect(Collectors.joining("\n"));
    }

    /** Factory Method con implementación por defecto (CSV). */
    protected Formateador crearFormateador() {
        return fila -> fila.get("id") + ";" + fila.get("nombre");
    }
}

class ExportadorJson extends Exportador {
    @Override
    protected Formateador crearFormateador() {
        return fila -> "{\"id\":" + fila.get("id") + ",\"nombre\":\"" + fila.get("nombre") + "\"}";
    }
}
