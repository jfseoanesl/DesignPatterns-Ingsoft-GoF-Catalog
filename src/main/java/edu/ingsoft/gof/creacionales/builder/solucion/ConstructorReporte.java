package edu.ingsoft.gof.creacionales.builder.solucion;

/** Builder: una operación por cada parte del producto. */
public interface ConstructorReporte {
    void titulo(String texto);

    void fila(String producto, double total);

    default void pie(String texto) {
        // opcional: los builders que no tengan pie lo ignoran
    }
}
