package edu.ingsoft.gof.estructurales.adapter.solucion;

/** Target: interfaz definida por y para el dominio. */
public interface ProcesadorPagos {
    ResultadoPago cobrar(Pago pago);

    ResultadoPago reembolsar(String transaccion, long valor);
}
