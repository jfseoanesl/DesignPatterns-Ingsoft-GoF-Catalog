package edu.ingsoft.gof.comportamiento.interpreter.problema;

import java.util.Map;

/** DEUDA TÉCNICA: análisis y evaluación mezclados con manipulación de cadenas. */
public class EvaluadorReglas {

    public boolean evaluar(String regla, Map<String, String> datos) {
        for (String alternativa : regla.split(" O ")) {          // re-analiza siempre
            boolean todas = true;
            for (String condicion : alternativa.split(" Y ")) {
                if (!comparar(condicion.trim(), datos)) {
                    todas = false;
                }
            }
            if (todas) {
                return true;
            }
        }
        return false;
    }

    private boolean comparar(String condicion, Map<String, String> datos) {
        String[] p = condicion.split(" ");
        String actual = datos.getOrDefault(p[0], "");
        if (p[1].equals("==")) {
            return actual.equals(p[2]);
        } else if (p[1].equals(">=")) {
            return actual.compareTo(p[2]) >= 0; // ¡compara texto, no números!
        }
        throw new IllegalArgumentException("Operador no soportado: " + p[1]);
    }
}
