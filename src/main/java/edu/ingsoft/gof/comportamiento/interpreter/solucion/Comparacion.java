package edu.ingsoft.gof.comportamiento.interpreter.solucion;

/** TerminalExpression: variable operador valor. */
public record Comparacion(String variable, String operador, String valor)
        implements Expresion {

    @Override
    public boolean interpretar(Contexto ctx) {
        String actual = ctx.valor(variable);
        return switch (operador) {
            case "==" -> actual.equals(valor);
            case "!=" -> !actual.equals(valor);
            case ">=" -> numero(actual) >= numero(valor);
            case "<=" -> numero(actual) <= numero(valor);
            case ">" -> numero(actual) > numero(valor);
            case "<" -> numero(actual) < numero(valor);
            default -> throw new IllegalArgumentException("Operador: " + operador);
        };
    }

    private static double numero(String s) {
        return s.isEmpty() ? Double.NaN : Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return variable + " " + operador + " " + valor;
    }
}
