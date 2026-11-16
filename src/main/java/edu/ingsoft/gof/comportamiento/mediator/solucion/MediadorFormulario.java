package edu.ingsoft.gof.comportamiento.mediator.solucion;

/** Mediator. */
public interface MediadorFormulario {
    void notificar(Componente emisor, String evento);
}
