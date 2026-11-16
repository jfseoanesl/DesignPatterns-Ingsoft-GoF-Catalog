package edu.ingsoft.gof.comportamiento.iterator.problema;

/** DEUDA TÉCNICA: representación interna pública y de tamaño fijo. */
public class ListaReproduccion {
    public Cancion[] canciones = new Cancion[10];
    public int total = 0;

    public void agregar(Cancion c) {
        canciones[total++] = c; // se desborda con la canción 11
    }
}
