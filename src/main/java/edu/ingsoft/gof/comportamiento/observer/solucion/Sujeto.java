package edu.ingsoft.gof.comportamiento.observer.solucion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/** Subject genérico y reutilizable. */
public class Sujeto<T> {
    private final List<Consumer<? super T>> observadores = new CopyOnWriteArrayList<>();

    public void suscribir(Consumer<? super T> o) {
        observadores.add(o);
    }

    public void desuscribir(Consumer<? super T> o) {
        observadores.remove(o);
    }

    protected void notificar(T evento) {
        observadores.forEach(o -> o.accept(evento));
    }
}
