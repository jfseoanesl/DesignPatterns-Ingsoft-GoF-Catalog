package edu.ingsoft.gof.comportamiento.templatemethod.problema;

import java.util.ArrayList;
import java.util.List;

/** DEUDA TÉCNICA: flujo completo duplicado en cada formato. */
public class ImportadorCsv {

    public String importar(String contenido) {
        List<Producto> productos = convertir(contenido);
        int validos = 0;
        int rechazados = 0;
        for (Producto p : productos) {
            if (validar(p)) {
                validos++; // guardar en BD...
            } else {
                rechazados++;
            }
        }
        return "CSV: " + validos + " válidos, " + rechazados + " rechazados";
    }

    private List<Producto> convertir(String contenido) {
        List<Producto> r = new ArrayList<>();
        for (String linea : contenido.split("\n")) {
            if (linea.startsWith("#")) {
                continue;
            }
            String[] c = linea.split(",");
            r.add(new Producto(c[0], Double.parseDouble(c[1])));
        }
        return r;
    }

    private boolean validar(Producto p) {
        return !p.sku().isBlank() && p.precio() > 0; // regla corregida
    }
}
