package edu.ingsoft.gof.comportamiento.interpreter.solucion;

/** NonterminalExpression: disyunción. */
public record O(Expresion izq, Expresion der) implements Expresion {
    @Override
    public boolean interpretar(Contexto ctx) {
        return izq.interpretar(ctx) || der.interpretar(ctx);
    }

    @Override
    public String toString() {
        return "(" + izq + " O " + der + ")";
    }
}
