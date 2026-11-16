package edu.ingsoft.gof.comportamiento.templatemethod.solucion;

import java.util.ArrayList;
import java.util.List;

/** AbstractClass: el esqueleto del algoritmo vive en un solo lugar. */
public abstract class ImportadorProductos {

    /** Método plantilla: final para proteger la estructura. */
    public final Informe importar(String contenido) {
        List<Producto> validos = new ArrayList<>();
        int rechazados = 0;
        for (Producto p : convertir(contenido)) {
            if (validar(p)) {
                validos.add(p);
            } else {
                rechazados++;
            }
        }
        guardar(validos);
        return new Informe(getClass().getSimpleName(), validos.size(), rechazados);
    }

    /** Operación primitiva obligatoria. */
    protected abstract List<Producto> convertir(String contenido);

    /** Paso común: la regla se corrige una sola vez para todos los formatos. */
    protected boolean validar(Producto p) {
        return !p.sku().isBlank() && p.precio() > 0;
    }

    /** Gancho opcional: por defecto no se ignora ninguna línea. */
    protected boolean esRegistroIgnorado(String linea) {
        return linea.isBlank();
    }

    /** Paso común (en producción: repositorio/BD). */
    protected void guardar(List<Producto> validos) {
        // persistencia simulada
    }
}
