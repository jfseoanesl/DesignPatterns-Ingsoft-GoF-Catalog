package edu.ingsoft.gof.comportamiento.mediator.solucion;

public class Boton extends Componente {
    private boolean habilitado;

    public void habilitar(boolean v) {
        habilitado = v;
    }

    public boolean habilitado() {
        return habilitado;
    }
}
