package edu.ingsoft.gof.comportamiento.interpreter.solucion;

/** AbstractExpression: nodo del árbol sintáctico. */
public sealed interface Expresion permits Comparacion, Y, O, No {
    boolean interpretar(Contexto ctx);
}
