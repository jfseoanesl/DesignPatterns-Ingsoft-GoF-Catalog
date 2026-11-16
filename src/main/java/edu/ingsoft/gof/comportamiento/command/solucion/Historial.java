package edu.ingsoft.gof.comportamiento.command.solucion;

import java.util.ArrayDeque;
import java.util.Deque;

/** Invoker: ejecuta comandos y administra deshacer/rehacer. */
public class Historial {
    private final Deque<Comando> deshacer = new ArrayDeque<>();
    private final Deque<Comando> rehacer = new ArrayDeque<>();

    public void ejecutar(Comando c) {
        c.ejecutar();
        deshacer.push(c);
        rehacer.clear(); // una acción nueva invalida el futuro
    }

    public void deshacer() {
        if (!deshacer.isEmpty()) {
            Comando c = deshacer.pop();
            c.deshacer();
            rehacer.push(c);
        }
    }

    public void rehacer() {
        if (!rehacer.isEmpty()) {
            Comando c = rehacer.pop();
            c.ejecutar();
            deshacer.push(c);
        }
    }
}
