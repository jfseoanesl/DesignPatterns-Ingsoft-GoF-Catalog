package edu.ingsoft.gof.comportamiento.mediator.ejemplos.torre;

import java.util.ArrayDeque;
import java.util.Deque;

/** Torre de control: los aviones no se coordinan entre ellos. */
public class Demo {
    public static void main(String[] args) {
        TorreControl torre = new TorreControl();
        Avion a1 = new Avion("AV123", torre);
        Avion a2 = new Avion("LA456", torre);
        Avion a3 = new Avion("CM789", torre);
        a1.solicitarAterrizaje();
        a2.solicitarAterrizaje();
        a3.solicitarAterrizaje();
        a1.liberarPista();
        a2.liberarPista();
    }
}

final class TorreControl {
    private Avion enPista;
    private final Deque<Avion> espera = new ArrayDeque<>();

    void solicitar(Avion a) {
        if (enPista == null) {
            enPista = a;
            a.autorizado();
        } else {
            espera.add(a);
            a.enEspera(espera.size());
        }
    }

    void liberar(Avion a) {
        if (a == enPista) {
            enPista = espera.poll();
            if (enPista != null) {
                enPista.autorizado();
            }
        }
    }
}

final class Avion {
    private final String id;
    private final TorreControl torre;

    Avion(String id, TorreControl t) {
        this.id = id;
        this.torre = t;
    }

    void solicitarAterrizaje() {
        torre.solicitar(this);
    }

    void liberarPista() {
        System.out.println(id + " libera la pista");
        torre.liberar(this);
    }

    void autorizado() {
        System.out.println(id + ": autorizado para aterrizar");
    }

    void enEspera(int turno) {
        System.out.println(id + ": en espera, turno " + turno);
    }
}
