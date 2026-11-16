package edu.ingsoft.gof.comportamiento.interpreter.problema;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        EvaluadorReglas ev = new EvaluadorReglas();
        String regla = "edad >= 18 Y pais == CO O vip == si";
        System.out.println("edad=25,CO  -> " + ev.evaluar(regla, Map.of("edad", "25",
                "pais", "CO", "vip", "no")));
        System.out.println("edad=9,CO   -> " + ev.evaluar(regla, Map.of("edad", "9",
                "pais", "CO", "vip", "no")) + "   (¡error! \"9\" >= \"18\" como texto)");
        try {
            ev.evaluar("NO vip == si", Map.of("vip", "no"));
        } catch (RuntimeException e) {
            System.out.println("NO no soportado: " + e.getClass().getSimpleName());
        }
    }
}
