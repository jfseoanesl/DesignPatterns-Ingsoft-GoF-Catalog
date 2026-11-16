package edu.ingsoft.gof.comportamiento.state.solucion;

/** State: por defecto, toda operación es inválida en el estado actual. */
public interface EstadoPedido {
    String nombre();

    default void pagar(Pedido p) {
        rechazar("pagar");
    }

    default void enviar(Pedido p) {
        rechazar("enviar");
    }

    default void entregar(Pedido p) {
        rechazar("entregar");
    }

    default void cancelar(Pedido p) {
        rechazar("cancelar");
    }

    private void rechazar(String operacion) {
        System.out.println("  No se puede " + operacion + " en estado " + nombre());
    }
}
