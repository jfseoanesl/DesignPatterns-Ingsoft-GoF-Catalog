package edu.ingsoft.gof.comportamiento.visitor.ejemplos.figuras;

import java.util.ArrayList;
import java.util.List;

/** Visitor sobre un Composite: el grupo recorre a sus hijos. */
public class Demo {
    public static void main(String[] args) {
        Grupo dibujo = new Grupo();
        dibujo.agregar(new Circulo(1));
        Grupo interno = new Grupo();
        interno.agregar(new Rectangulo(2, 3));
        interno.agregar(new Circulo(0.5));
        dibujo.agregar(interno);

        CalculadoraArea area = new CalculadoraArea();
        dibujo.aceptar(area);
        System.out.printf("Área total: %.2f%n", area.total());

        ExportadorSvg svg = new ExportadorSvg();
        dibujo.aceptar(svg);
        System.out.println(svg.resultado());
    }
}

interface VisitanteFigura {
    void visitar(Circulo c);

    void visitar(Rectangulo r);

    void visitar(Grupo g);
}

interface Figura {
    void aceptar(VisitanteFigura v);
}

record Circulo(double radio) implements Figura {
    @Override
    public void aceptar(VisitanteFigura v) {
        v.visitar(this);
    }
}

record Rectangulo(double ancho, double alto) implements Figura {
    @Override
    public void aceptar(VisitanteFigura v) {
        v.visitar(this);
    }
}

final class Grupo implements Figura {
    private final List<Figura> hijos = new ArrayList<>();

    void agregar(Figura f) {
        hijos.add(f);
    }

    List<Figura> hijos() {
        return hijos;
    }

    @Override
    public void aceptar(VisitanteFigura v) {
        v.visitar(this);
    }
}

final class CalculadoraArea implements VisitanteFigura {
    private double total;

    @Override
    public void visitar(Circulo c) {
        total += Math.PI * c.radio() * c.radio();
    }

    @Override
    public void visitar(Rectangulo r) {
        total += r.ancho() * r.alto();
    }

    @Override
    public void visitar(Grupo g) {
        g.hijos().forEach(h -> h.aceptar(this));
    }

    double total() {
        return total;
    }
}

final class ExportadorSvg implements VisitanteFigura {
    private final StringBuilder sb = new StringBuilder();
    private int nivel;

    @Override
    public void visitar(Circulo c) {
        linea("<circle r=\"" + c.radio() + "\"/>");
    }

    @Override
    public void visitar(Rectangulo r) {
        linea("<rect width=\"" + r.ancho() + "\" height=\"" + r.alto() + "\"/>");
    }

    @Override
    public void visitar(Grupo g) {
        linea("<g>");
        nivel++;
        g.hijos().forEach(h -> h.aceptar(this));
        nivel--;
        linea("</g>");
    }

    private void linea(String s) {
        sb.append("  ".repeat(nivel)).append(s).append('\n');
    }

    String resultado() {
        return sb.toString().stripTrailing();
    }
}
