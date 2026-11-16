package edu.ingsoft.gof.comportamiento.interpreter.ejemplos.aritmetica;

import java.util.Map;

/** Intérprete aritmético: AST con records y dos interpretaciones (evaluar e imprimir). */
public class Demo {
    public static void main(String[] args) {
        // (precio * cantidad) - descuento
        Expr total = new Resta(new Mult(new Var("precio"), new Var("cantidad")),
                new Var("descuento"));
        Map<String, Double> ctx = Map.of("precio", 12_500.0, "cantidad", 4.0,
                "descuento", 5_000.0);
        System.out.println(total.imprimir() + " = " + total.evaluar(ctx));
    }
}

sealed interface Expr permits Num, Var, Suma, Resta, Mult {
    double evaluar(Map<String, Double> ctx);

    String imprimir();
}

record Num(double v) implements Expr {
    @Override
    public double evaluar(Map<String, Double> c) {
        return v;
    }

    @Override
    public String imprimir() {
        return String.valueOf(v);
    }
}

record Var(String nombre) implements Expr {
    @Override
    public double evaluar(Map<String, Double> c) {
        Double v = c.get(nombre);
        if (v == null) {
            throw new IllegalArgumentException("Variable sin valor: " + nombre);
        }
        return v;
    }

    @Override
    public String imprimir() {
        return nombre;
    }
}

record Suma(Expr a, Expr b) implements Expr {
    @Override
    public double evaluar(Map<String, Double> c) {
        return a.evaluar(c) + b.evaluar(c);
    }

    @Override
    public String imprimir() {
        return "(" + a.imprimir() + " + " + b.imprimir() + ")";
    }
}

record Resta(Expr a, Expr b) implements Expr {
    @Override
    public double evaluar(Map<String, Double> c) {
        return a.evaluar(c) - b.evaluar(c);
    }

    @Override
    public String imprimir() {
        return "(" + a.imprimir() + " - " + b.imprimir() + ")";
    }
}

record Mult(Expr a, Expr b) implements Expr {
    @Override
    public double evaluar(Map<String, Double> c) {
        return a.evaluar(c) * b.evaluar(c);
    }

    @Override
    public String imprimir() {
        return a.imprimir() + " * " + b.imprimir();
    }
}
