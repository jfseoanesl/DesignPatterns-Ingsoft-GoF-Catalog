package edu.ingsoft.gof.comportamiento.state.solucion;

public class Enviado implements EstadoPedido {
    @Override
    public String nombre() {
        return "ENVIADO";
    }

    @Override
    public void entregar(Pedido p) {
        p.transicionar(new Entregado());
    }
}
