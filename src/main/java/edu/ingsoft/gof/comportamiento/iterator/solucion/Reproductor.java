package edu.ingsoft.gof.comportamiento.iterator.solucion;

import java.util.StringJoiner;

/** Cliente: recorre cualquier Iterable sin conocer la representación. */
public class Reproductor {

    public String reproducir(Iterable<Cancion> canciones) {
        StringJoiner sj = new StringJoiner(" | ");
        for (Cancion c : canciones) {
            sj.add(c.titulo());
        }
        return sj.toString();
    }
}
