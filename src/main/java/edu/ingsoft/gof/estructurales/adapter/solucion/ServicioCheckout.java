package edu.ingsoft.gof.estructurales.adapter.solucion;

/** Client: solo conoce la interfaz del dominio. */
public class ServicioCheckout {
    private final ProcesadorPagos procesador;

    public ServicioCheckout(ProcesadorPagos procesador) {
        this.procesador = procesador;
    }

    public String finalizarCompra(String cliente, long valor) {
        ResultadoPago r = procesador.cobrar(new Pago(cliente, valor));
        return r.aprobado() ? "Compra confirmada (" + r.transaccion() + ")"
                            : "Pago rechazado";
    }
}
