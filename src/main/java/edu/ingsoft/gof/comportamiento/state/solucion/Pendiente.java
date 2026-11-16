package edu.ingsoft.gof.comportamiento.state.solucion;

public class Pendiente implements EstadoPedido {
    @Override
    public String nombre() {
        return "PENDIENTE";
    }

    @Override
    public void pagar(Pedido p) {
        p.transicionar(new Pagado());
    }

    @Override
    public void cancelar(Pedido p) {
        p.transicionar(new Cancelado());
    }
}
