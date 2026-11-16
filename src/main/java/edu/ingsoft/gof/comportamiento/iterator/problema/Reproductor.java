package edu.ingsoft.gof.comportamiento.iterator.problema;

import java.util.Random;

/** El cliente conoce el arreglo y reimplementa cada recorrido. */
public class Reproductor {

    public void reproducirTodo(ListaReproduccion l) {
        for (int i = 0; i < l.total; i++) {
            System.out.print(l.canciones[i].titulo() + " | ");
        }
        System.out.println();
    }

    public void reproducirAleatorio(ListaReproduccion l) {
        Random r = new Random(7);
        for (int i = 0; i < l.total; i++) {
            // puede repetir canciones y omitir otras
            System.out.print(l.canciones[r.nextInt(l.total)].titulo() + " | ");
        }
        System.out.println();
    }
}
