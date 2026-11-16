package edu.ingsoft.gof.comportamiento.interpreter.solucion;

import java.util.Map;

/** Context: valores de las variables. */
public class Contexto {
    private final Map<String, String> valores;

    public Contexto(Map<String, String> valores) {
        this.valores = Map.copyOf(valores);
    }

    public String valor(String variable) {
        return valores.getOrDefault(variable, "");
    }
}
