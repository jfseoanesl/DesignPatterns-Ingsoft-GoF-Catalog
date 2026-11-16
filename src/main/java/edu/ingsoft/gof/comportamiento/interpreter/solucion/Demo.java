package edu.ingsoft.gof.comportamiento.interpreter.solucion;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Expresion regla = Parser.analizar("edad >= 18 Y pais == CO O vip == si");
        System.out.println("AST: " + regla);
        System.out.println("edad=25,CO -> " + regla.interpretar(new Contexto(
                Map.of("edad", "25", "pais", "CO", "vip", "no"))));
        System.out.println("edad=9,CO  -> " + regla.interpretar(new Contexto(
                Map.of("edad", "9", "pais", "CO", "vip", "no"))));

        Expresion compleja = Parser.analizar("NO ( vip == si ) Y ( compras > 3 O edad < 25 )");
        System.out.println("NO/paréntesis -> " + compleja.interpretar(new Contexto(
                Map.of("vip", "no", "compras", "5", "edad", "40"))));
    }
}
