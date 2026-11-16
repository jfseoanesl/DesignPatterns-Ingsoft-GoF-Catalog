package edu.ingsoft.gof.comportamiento.visitor.problema;

/** Para no tocar las 3 clases, alguien recurrió a instanceof. */
public class Reporte {
    public double costoEnvio(Articulo a) {
        if (a instanceof Electronico) {
            return 15_000;
        } else if (a instanceof Alimento) {
            return 8_000;
        }
        return 5_000; // ¿y si se agrega un tipo nuevo? Cae aquí en silencio
    }
}
