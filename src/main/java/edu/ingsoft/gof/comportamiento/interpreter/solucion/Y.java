package edu.ingsoft.gof.comportamiento.interpreter.solucion;

/** NonterminalExpression: conjunción. */
public record Y(Expresion izq, Expresion der) implements Expresion {
    @Override
    public boolean interpretar(Contexto ctx) {
        return izq.interpretar(ctx) && der.interpretar(ctx);
    }

    @Override
    public String toString() {
        return "(" + izq + " Y " + der + ")";
    }
}
