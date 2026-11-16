package edu.ingsoft.gof.creacionales.prototype.ejemplos.profundidad;

import java.util.ArrayList;
import java.util.List;

/** Object.clone() hace copia superficial: hay que corregirla manualmente. */
public class Demo {
    public static void main(String[] args) {
        PlaylistSuperficial a = new PlaylistSuperficial();
        a.canciones.add("Tema 1");
        PlaylistSuperficial b = a.clone();
        b.canciones.add("Tema 2");
        System.out.println("Superficial -> a=" + a.canciones + " b=" + b.canciones);

        PlaylistProfunda c = new PlaylistProfunda();
        c.canciones.add("Tema 1");
        PlaylistProfunda d = c.clone();
        d.canciones.add("Tema 2");
        System.out.println("Profunda    -> c=" + c.canciones + " d=" + d.canciones);
    }
}

class PlaylistSuperficial implements Cloneable {
    List<String> canciones = new ArrayList<>();

    @Override
    public PlaylistSuperficial clone() {
        try {
            return (PlaylistSuperficial) super.clone(); // comparte la lista
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

class PlaylistProfunda implements Cloneable {
    List<String> canciones = new ArrayList<>();

    @Override
    public PlaylistProfunda clone() {
        try {
            PlaylistProfunda copia = (PlaylistProfunda) super.clone();
            copia.canciones = new ArrayList<>(canciones); // corrige el aliasing
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
