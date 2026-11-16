package edu.ingsoft.gof.creacionales.prototype.solucion;

public class Circulo extends Figura {
    private final int radio;

    public Circulo(int x, int y, int radio) {
        super(x, y);
        this.radio = radio;
    }

    private Circulo(Circulo otro) {
        super(otro);
        this.radio = otro.radio;
    }

    @Override
    public Circulo copiar() { // retorno covariante
        return new Circulo(this);
    }

    @Override
    public String toString() {
        return "Circulo(" + x + "," + y + ",r=" + radio + ")";
    }
}
