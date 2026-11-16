package edu.ingsoft.gof.estructurales.flyweight.solucion;

import java.util.ArrayList;
import java.util.List;

public class Bosque {
    private final List<Arbol> arboles = new ArrayList<>();
    private final FabricaTiposArbol fabrica = new FabricaTiposArbol();

    public void plantar(int x, int y, String especie, String color) {
        arboles.add(new Arbol(x, y, fabrica.obtener(especie, color)));
    }

    public int cantidad() {
        return arboles.size();
    }

    public FabricaTiposArbol fabrica() {
        return fabrica;
    }

    public String dibujar(int i) {
        return arboles.get(i).dibujar();
    }
}
