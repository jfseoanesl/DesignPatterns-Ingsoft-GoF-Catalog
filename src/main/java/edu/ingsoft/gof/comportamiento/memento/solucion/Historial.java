package edu.ingsoft.gof.comportamiento.memento.solucion;

import java.util.ArrayDeque;
import java.util.Deque;

/** Caretaker: custodia instantáneas sin conocer su contenido. */
public class Historial {
    private final Editor editor;
    private final Deque<Editor.Instantanea> pila = new ArrayDeque<>();

    public Historial(Editor editor) {
        this.editor = editor;
    }

    public void respaldar() {
        pila.push(editor.guardar());
    }

    public void deshacer() {
        if (!pila.isEmpty()) {
            Editor.Instantanea m = pila.pop();
            System.out.println("  restaurando instantánea de " + m.etiqueta());
            editor.restaurar(m);
        }
    }
}
