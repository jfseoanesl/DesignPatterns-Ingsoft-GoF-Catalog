package edu.ingsoft.gof.comportamiento.state.solucion;

public class Cancelado implements EstadoPedido {
    @Override
    public String nombre() {
        return "CANCELADO";
    }
}
