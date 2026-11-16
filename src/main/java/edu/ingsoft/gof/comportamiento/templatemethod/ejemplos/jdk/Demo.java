package edu.ingsoft.gof.comportamiento.templatemethod.ejemplos.jdk;

import java.util.AbstractList;
import java.util.List;

/** AbstractList: con get() y size() se obtienen contains, indexOf, iterator, subList... */
public class Demo {
    public static void main(String[] args) {
        List<Integer> pares = new RangoPares(10);
        System.out.println("Lista: " + pares);
        System.out.println("contains(6): " + pares.contains(6));
        System.out.println("indexOf(8): " + pares.indexOf(8));
        System.out.println("subList(1,3): " + pares.subList(1, 3));
        try {
            pares.add(12);
        } catch (UnsupportedOperationException e) {
            System.out.println("add(): no soportado (operación por defecto de la plantilla)");
        }
    }
}

final class RangoPares extends AbstractList<Integer> {
    private final int hasta;

    RangoPares(int hasta) {
        this.hasta = hasta;
    }

    @Override
    public Integer get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException(i);
        }
        return i * 2;
    }

    @Override
    public int size() {
        return hasta / 2 + 1;
    }
}
