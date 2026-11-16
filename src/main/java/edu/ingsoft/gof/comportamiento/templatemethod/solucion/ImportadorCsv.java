package edu.ingsoft.gof.comportamiento.templatemethod.solucion;

import java.util.ArrayList;
import java.util.List;

public class ImportadorCsv extends ImportadorProductos {
    @Override
    protected List<Producto> convertir(String contenido) {
        List<Producto> r = new ArrayList<>();
        for (String linea : contenido.split("\n")) {
            if (esRegistroIgnorado(linea)) {
                continue;
            }
            String[] c = linea.split(",");
            r.add(new Producto(c[0].trim(), Double.parseDouble(c[1].trim())));
        }
        return r;
    }

    @Override
    protected boolean esRegistroIgnorado(String linea) {
        return super.esRegistroIgnorado(linea) || linea.startsWith("#");
    }
}
