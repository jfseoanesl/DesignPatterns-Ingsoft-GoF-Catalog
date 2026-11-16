package edu.ingsoft.gof.comportamiento.visitor.ejemplos.expresiones;

/** Dos visitantes sobre el mismo AST: evaluar e imprimir. */
public class Demo {
    public static void main(String[] args) {
        Nodo expr = new Suma(new Numero(2), new Producto(new Numero(3), new Numero(4)));
        System.out.println(expr.aceptar(new Impresor()) + " = " + expr.aceptar(new Evaluador()));
    }
}

interface VisitanteExpr<R> {
    R visitar(Numero n);

    R visitar(Suma s);

    R visitar(Producto p);
}

interface Nodo {
    <R> R aceptar(VisitanteExpr<R> v);
}

record Numero(int valor) implements Nodo {
    @Override
    public <R> R aceptar(VisitanteExpr<R> v) {
        return v.visitar(this);
    }
}

record Suma(Nodo izq, Nodo der) implements Nodo {
    @Override
    public <R> R aceptar(VisitanteExpr<R> v) {
        return v.visitar(this);
    }
}

record Producto(Nodo izq, Nodo der) implements Nodo {
    @Override
    public <R> R aceptar(VisitanteExpr<R> v) {
        return v.visitar(this);
    }
}

final class Evaluador implements VisitanteExpr<Integer> {
    @Override
    public Integer visitar(Numero n) {
        return n.valor();
    }

    @Override
    public Integer visitar(Suma s) {
        return s.izq().aceptar(this) + s.der().aceptar(this);
    }

    @Override
    public Integer visitar(Producto p) {
        return p.izq().aceptar(this) * p.der().aceptar(this);
    }
}

final class Impresor implements VisitanteExpr<String> {
    @Override
    public String visitar(Numero n) {
        return String.valueOf(n.valor());
    }

    @Override
    public String visitar(Suma s) {
        return "(" + s.izq().aceptar(this) + " + " + s.der().aceptar(this) + ")";
    }

    @Override
    public String visitar(Producto p) {
        return s(p.izq()) + " * " + s(p.der());
    }

    private String s(Nodo n) {
        return n.aceptar(this);
    }
}
