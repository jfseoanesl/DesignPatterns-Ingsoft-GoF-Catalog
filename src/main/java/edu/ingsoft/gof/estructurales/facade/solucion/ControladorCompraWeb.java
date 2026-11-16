package edu.ingsoft.gof.estructurales.facade.solucion;

public class ControladorCompraWeb {
    private final FachadaCompras compras;

    public ControladorCompraWeb(FachadaCompras compras) {
        this.compras = compras;
    }

    public String comprar(String cliente, String sku, int cant, String tarjeta) {
        return compras.comprar(new SolicitudCompra(cliente, sku, cant, tarjeta));
    }
}
