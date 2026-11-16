package edu.ingsoft.gof.estructurales.flyweight.solucion;

/** Contexto: solo estado extrínseco + referencia al flyweight. */
public record Arbol(int x, int y, TipoArbol tipo) {

    public String dibujar() {
        return tipo.dibujar(x, y);
    }
}
