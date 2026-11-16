package edu.ingsoft.gof.creacionales.prototype.solucion;

public class Rectangulo extends Figura {
    private final int ancho;
    private final int alto;

    public Rectangulo(int x, int y, int ancho, int alto) {
        super(x, y);
        this.ancho = ancho;
        this.alto = alto;
    }

    private Rectangulo(Rectangulo otro) {
        super(otro);
        this.ancho = otro.ancho;
        this.alto = otro.alto;
    }

    @Override
    public Rectangulo copiar() {
        return new Rectangulo(this);
    }

    @Override
    public String toString() {
        return "Rect(" + x + "," + y + "," + ancho + "x" + alto + ")";
    }
}
