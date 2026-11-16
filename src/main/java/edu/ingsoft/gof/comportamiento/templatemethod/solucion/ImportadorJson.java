package edu.ingsoft.gof.comportamiento.templatemethod.solucion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportadorJson extends ImportadorProductos {
    private static final Pattern P =
            Pattern.compile("\\{\"sku\":\"([^\"]*)\",\"precio\":(-?[0-9.]+)}");

    @Override
    protected List<Producto> convertir(String contenido) {
        List<Producto> r = new ArrayList<>();
        Matcher m = P.matcher(contenido);
        while (m.find()) {
            r.add(new Producto(m.group(1), Double.parseDouble(m.group(2))));
        }
        return r;
    }
}
