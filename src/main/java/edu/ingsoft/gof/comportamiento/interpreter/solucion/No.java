package edu.ingsoft.gof.comportamiento.interpreter.solucion;

/** NonterminalExpression: negación. */
public record No(Expresion expr) implements Expresion {
    @Override
    public boolean interpretar(Contexto ctx) {
        return !expr.interpretar(ctx);
    }

    @Override
    public String toString() {
        return "NO " + expr;
    }
}
