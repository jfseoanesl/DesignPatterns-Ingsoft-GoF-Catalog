package edu.ingsoft.gof.estructurales.flyweight.problema;

import java.util.ArrayList;
import java.util.List;

public class Bosque {
    private final List<Arbol> arboles = new ArrayList<>();

    public void plantar(int x, int y, String especie, String color) {
        arboles.add(new Arbol(x, y, especie, color));
    }

    public long bytesTexturas() {
        return arboles.stream().mapToLong(Arbol::bytesTextura).sum();
    }

    public int cantidad() {
        return arboles.size();
    }
}
