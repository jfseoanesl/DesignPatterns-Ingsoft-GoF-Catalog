package edu.ingsoft.gof.creacionales.prototype.solucion;

/** Prototype: cada figura sabe copiarse a sí misma. */
public abstract class Figura {
    protected int x;
    protected int y;

    protected Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Constructor de copia usado por las subclases. */
    protected Figura(Figura otra) {
        this(otra.x, otra.y);
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract Figura copiar();
}
