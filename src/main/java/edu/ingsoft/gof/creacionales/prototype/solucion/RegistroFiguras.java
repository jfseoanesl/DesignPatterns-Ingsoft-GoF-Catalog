package edu.ingsoft.gof.creacionales.prototype.solucion;

import java.util.HashMap;
import java.util.Map;

/** Registro de prototipos: paleta de figuras preconfiguradas. */
public class RegistroFiguras {
    private final Map<String, Figura> prototipos = new HashMap<>();

    public void registrar(String nombre, Figura prototipo) {
        prototipos.put(nombre, prototipo);
    }

    public Figura crear(String nombre) {
        Figura p = prototipos.get(nombre);
        if (p == null) {
            throw new IllegalArgumentException("Prototipo inexistente: " + nombre);
        }
        return p.copiar(); // nunca se expone el original
    }
}
