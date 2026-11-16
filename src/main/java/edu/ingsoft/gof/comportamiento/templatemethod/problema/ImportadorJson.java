package edu.ingsoft.gof.comportamiento.templatemethod.problema;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** DEUDA TÉCNICA: copia del flujo... con la validación desactualizada. */
public class ImportadorJson {
    private static final Pattern P =
            Pattern.compile("\\{\"sku\":\"([^\"]*)\",\"precio\":(-?[0-9.]+)}");

    public String importar(String contenido) {
        List<Producto> productos = convertir(contenido);
        int validos = 0;
        int rechazados = 0;
        for (Producto p : productos) {
            if (validar(p)) {
                validos++;
            } else {
                rechazados++;
            }
        }
        return "JSON: " + validos + " válidos, " + rechazados + " rechazados";
    }

    private List<Producto> convertir(String contenido) {
        List<Producto> r = new ArrayList<>();
        Matcher m = P.matcher(contenido);
        while (m.find()) {
            r.add(new Producto(m.group(1), Double.parseDouble(m.group(2))));
        }
        return r;
    }

    private boolean validar(Producto p) {
        return !p.sku().isBlank(); // ¡olvidó validar el precio!
    }
}
