package edu.ingsoft.gof.comportamiento.memento.ejemplos.borrador;

import java.util.ArrayDeque;
import java.util.Deque;

/** Cuidador con historial acotado: conserva solo las últimas N instantáneas. */
public class Demo {
    public static void main(String[] args) {
        Formulario f = new Formulario();
        HistorialAcotado h = new HistorialAcotado(3);
        String[] pasos = {"A", "An", "Ana", "Ana P", "Ana Pé", "Ana Pérez"};
        for (String nombre : pasos) {
            h.guardar(f.instantanea());
            f.nombre = nombre;
        }
        System.out.println("Actual: " + f.nombre + " | instantáneas guardadas: " + h.tamano());
        while (h.tamano() > 0) {
            f.restaurar(h.ultima());
            System.out.println("Deshacer -> " + f.nombre);
        }
    }
}

final class Formulario {
    String nombre = "";

    Borrador instantanea() {
        return new Borrador(nombre);
    }

    void restaurar(Borrador b) {
        nombre = b.nombre();
    }

    record Borrador(String nombre) {
    }
}

final class HistorialAcotado {
    private final int maximo;
    private final Deque<Formulario.Borrador> pila = new ArrayDeque<>();

    HistorialAcotado(int maximo) {
        this.maximo = maximo;
    }

    void guardar(Formulario.Borrador b) {
        pila.push(b);
        if (pila.size() > maximo) {
            pila.removeLast(); // descarta la más antigua
        }
    }

    Formulario.Borrador ultima() {
        return pila.pop();
    }

    int tamano() {
        return pila.size();
    }
}
