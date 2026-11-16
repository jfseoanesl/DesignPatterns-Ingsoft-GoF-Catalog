package edu.ingsoft.gof.comportamiento.interpreter.ejemplos.romanos;

import java.util.List;

/** Intérprete clásico de números romanos (millares, centenas, decenas, unidades). */
public class Demo {
    public static void main(String[] args) {
        for (String romano : List.of("XIV", "MCMXCIV", "MMXXVI")) {
            System.out.println(romano + " = " + Romano.interpretar(romano));
        }
    }
}

final class Contexto {
    String entrada;
    int salida;

    Contexto(String entrada) {
        this.entrada = entrada;
    }
}

/** Expresión terminal parametrizada por los símbolos de su posición. */
final class ExpresionPosicion {
    private final String uno;
    private final String cuatro;
    private final String cinco;
    private final String nueve;
    private final int multiplicador;

    ExpresionPosicion(String uno, String cuatro, String cinco, String nueve, int mult) {
        this.uno = uno;
        this.cuatro = cuatro;
        this.cinco = cinco;
        this.nueve = nueve;
        this.multiplicador = mult;
    }

    void interpretar(Contexto c) {
        if (c.entrada.startsWith(nueve)) {
            consumir(c, nueve, 9);
        } else if (c.entrada.startsWith(cuatro)) {
            consumir(c, cuatro, 4);
        } else {
            if (c.entrada.startsWith(cinco)) {
                consumir(c, cinco, 5);
            }
            while (c.entrada.startsWith(uno)) {
                consumir(c, uno, 1);
            }
        }
    }

    private void consumir(Contexto c, String s, int valor) {
        c.salida += valor * multiplicador;
        c.entrada = c.entrada.substring(s.length());
    }
}

final class Romano {
    private static final List<ExpresionPosicion> ARBOL = List.of(
            new ExpresionPosicion("M", "--", "--", "--", 1000),
            new ExpresionPosicion("C", "CD", "D", "CM", 100),
            new ExpresionPosicion("X", "XL", "L", "XC", 10),
            new ExpresionPosicion("I", "IV", "V", "IX", 1));

    static int interpretar(String romano) {
        Contexto c = new Contexto(romano);
        ARBOL.forEach(e -> e.interpretar(c));
        return c.salida;
    }
}
