package edu.ingsoft.gof.comportamiento.mediator.solucion;

public class CasillaEmpresa extends Componente {
    private boolean marcada;

    public void marcar(boolean v) {
        marcada = v;
        cambio("tipo-cliente");
    }

    public boolean marcada() {
        return marcada;
    }
}
