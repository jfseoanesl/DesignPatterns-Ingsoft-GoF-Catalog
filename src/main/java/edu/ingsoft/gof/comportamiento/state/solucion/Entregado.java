package edu.ingsoft.gof.comportamiento.state.solucion;

public class Entregado implements EstadoPedido {
    @Override
    public String nombre() {
        return "ENTREGADO";
    }
}
