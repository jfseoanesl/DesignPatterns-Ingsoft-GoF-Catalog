package edu.ingsoft.gof.estructurales.decorator.solucion;

/** Component. */
public interface FuenteDatos {
    void escribir(byte[] datos);

    byte[] leer();
}
