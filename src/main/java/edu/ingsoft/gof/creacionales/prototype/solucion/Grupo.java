package edu.ingsoft.gof.creacionales.prototype.solucion;

import java.util.ArrayList;
import java.util.List;

public class Grupo extends Figura {
    private final List<Figura> hijos = new ArrayList<>();

    public Grupo() {
        super(0, 0);
    }

    private Grupo(Grupo otro) {
        super(otro);
        for (Figura h : otro.hijos) {
            hijos.add(h.copiar()); // copia profunda
        }
    }

    public void agregar(Figura f) {
        hijos.add(f);
    }

    @Override
    public void mover(int dx, int dy) {
        hijos.forEach(h -> h.mover(dx, dy));
    }

    @Override
    public Grupo copiar() {
        return new Grupo(this);
    }

    @Override
    public String toString() {
        return "Grupo" + hijos;
    }
}
