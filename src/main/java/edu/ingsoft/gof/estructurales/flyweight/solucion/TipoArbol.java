package edu.ingsoft.gof.estructurales.flyweight.solucion;

/** Flyweight: estado intrínseco inmutable y compartido. */
public record TipoArbol(String especie, String color, byte[] textura) {

    public String dibujar(int x, int y) { // recibe el estado extrínseco
        return especie + "(" + color + ") en " + x + "," + y;
    }
}
