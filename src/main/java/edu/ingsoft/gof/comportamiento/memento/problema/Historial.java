package edu.ingsoft.gof.comportamiento.memento.problema;

import java.util.ArrayDeque;
import java.util.Deque;

/** DEUDA TÉCNICA: el cuidador conoce y copia los campos uno a uno. */
public class Historial {
    private final Deque<Object[]> copias = new ArrayDeque<>();

    public void guardar(Editor e) {
        copias.push(new Object[] {e.texto, e.cursor}); // ¡falta fuente!
    }

    public void deshacer(Editor e) {
        Object[] c = copias.pop();
        e.texto = (String) c[0];
        e.cursor = (Integer) c[1];
    }
}
