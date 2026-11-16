package edu.ingsoft.gof.comportamiento.observer.solucion;

import java.util.function.Consumer;

/** Observer. */
@FunctionalInterface
public interface ObservadorClima extends Consumer<Medicion> {
    void actualizar(Medicion m);

    @Override
    default void accept(Medicion m) {
        actualizar(m);
    }
}
