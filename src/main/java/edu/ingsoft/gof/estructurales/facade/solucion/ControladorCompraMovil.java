package edu.ingsoft.gof.estructurales.facade.solucion;

public class ControladorCompraMovil {
    private final FachadaCompras compras;

    public ControladorCompraMovil(FachadaCompras compras) {
        this.compras = compras;
    }

    public String comprar(String cliente, String sku, int cant, String tarjeta) {
        return compras.comprar(new SolicitudCompra(cliente, sku, cant, tarjeta));
    }
}
