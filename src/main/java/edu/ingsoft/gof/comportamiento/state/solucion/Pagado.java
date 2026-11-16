package edu.ingsoft.gof.comportamiento.state.solucion;

public class Pagado implements EstadoPedido {
    @Override
    public String nombre() {
        return "PAGADO";
    }

    @Override
    public void enviar(Pedido p) {
        p.transicionar(new Enviado());
    }

    @Override
    public void cancelar(Pedido p) {
        System.out.println("  Reembolsando pago...");
        p.transicionar(new Cancelado());
    }
}
