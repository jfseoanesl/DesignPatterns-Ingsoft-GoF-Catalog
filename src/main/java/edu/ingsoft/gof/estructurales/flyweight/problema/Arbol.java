package edu.ingsoft.gof.estructurales.flyweight.problema;

/** DEUDA TÉCNICA: cada árbol carga su propia copia de la textura. */
public class Arbol {
    private final int x;
    private final int y;
    private final String especie;
    private final String color;
    private final byte[] textura;

    public Arbol(int x, int y, String especie, String color) {
        this.x = x;
        this.y = y;
        this.especie = especie;
        this.color = color;
        this.textura = new byte[2048]; // simula leer la imagen de la especie
    }

    public String dibujar() {
        return especie + "(" + color + ") en " + x + "," + y;
    }

    public int bytesTextura() {
        return textura.length;
    }
}
