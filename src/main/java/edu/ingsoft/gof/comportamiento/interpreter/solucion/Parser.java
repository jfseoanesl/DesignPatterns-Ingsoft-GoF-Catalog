package edu.ingsoft.gof.comportamiento.interpreter.solucion;

import java.util.Arrays;
import java.util.List;

/**
 * Parser descendente recursivo (no forma parte del patrón, construye el AST).
 * Gramática:  o := y ("O" y)* ;  y := unaria ("Y" unaria)* ;
 *             unaria := "NO" unaria | "(" o ")" | VAR OP VALOR
 */
public final class Parser {
    private final List<String> tokens;
    private int pos;

    private Parser(String regla) {
        this.tokens = Arrays.asList(regla.replace("(", " ( ").replace(")", " ) ")
                .trim().split("\\s+"));
    }

    public static Expresion analizar(String regla) {
        Parser p = new Parser(regla);
        Expresion e = p.o();
        if (p.pos != p.tokens.size()) {
            throw new IllegalArgumentException("Token inesperado: " + p.tokens.get(p.pos));
        }
        return e;
    }

    private Expresion o() {
        Expresion e = y();
        while (acepta("O")) {
            e = new O(e, y());
        }
        return e;
    }

    private Expresion y() {
        Expresion e = unaria();
        while (acepta("Y")) {
            e = new Y(e, unaria());
        }
        return e;
    }

    private Expresion unaria() {
        if (acepta("NO")) {
            return new No(unaria());
        }
        if (acepta("(")) {
            Expresion e = o();
            if (!acepta(")")) {
                throw new IllegalArgumentException("Falta ')'");
            }
            return e;
        }
        return new Comparacion(tokens.get(pos++), tokens.get(pos++), tokens.get(pos++));
    }

    private boolean acepta(String t) {
        if (pos < tokens.size() && tokens.get(pos).equals(t)) {
            pos++;
            return true;
        }
        return false;
    }
}
