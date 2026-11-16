package edu.ingsoft.gof.estructurales.bridge.ejemplos.graficos;

import java.util.List;

/** Figuras (abstracción) independientes del motor de renderizado (implementación). */
public class Demo {
    public static void main(String[] args) {
        for (Renderizador r : List.of(new RenderSvg(), new RenderAscii())) {
            List<Figura> figuras = List.of(new Circulo(r, 3), new Cuadrado(r, 4));
            figuras.forEach(f -> System.out.println(f.dibujar()));
        }
    }
}

interface Renderizador {
    String circulo(int radio);

    String rectangulo(int ancho, int alto);
}

final class RenderSvg implements Renderizador {
    @Override
    public String circulo(int r) {
        return "<circle r=\"" + r + "\"/>";
    }

    @Override
    public String rectangulo(int w, int h) {
        return "<rect width=\"" + w + "\" height=\"" + h + "\"/>";
    }
}

final class RenderAscii implements Renderizador {
    @Override
    public String circulo(int r) {
        return "(" + " ".repeat(r) + ")";
    }

    @Override
    public String rectangulo(int w, int h) {
        return "[" + "#".repeat(w) + "]x" + h;
    }
}

abstract class Figura {
    protected final Renderizador render;

    Figura(Renderizador r) {
        this.render = r;
    }

    abstract String dibujar();
}

final class Circulo extends Figura {
    private final int radio;

    Circulo(Renderizador r, int radio) {
        super(r);
        this.radio = radio;
    }

    @Override
    String dibujar() {
        return render.circulo(radio);
    }
}

final class Cuadrado extends Figura {
    private final int lado;

    Cuadrado(Renderizador r, int lado) {
        super(r);
        this.lado = lado;
    }

    @Override
    String dibujar() {
        return render.rectangulo(lado, lado);
    }
}
