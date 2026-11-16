package edu.ingsoft.gof.comportamiento.mediator.solucion;

/** Colleague base: solo conoce al mediador. */
public abstract class Componente {
    protected MediadorFormulario mediador;

    void setMediador(MediadorFormulario m) {
        this.mediador = m;
    }

    protected void cambio(String evento) {
        if (mediador != null) {
            mediador.notificar(this, evento);
        }
    }
}
