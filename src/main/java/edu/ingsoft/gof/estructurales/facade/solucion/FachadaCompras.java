package edu.ingsoft.gof.estructurales.facade.solucion;

/** Facade: única puerta de entrada al subsistema de compras. */
public class FachadaCompras {
    private static final long PRECIO_UNITARIO = 50_000L;

    private final Inventario inventario;
    private final Pagos pagos;
    private final Envios envios;
    private final Facturacion facturacion;
    private final Notificador notificador;

    public FachadaCompras(Inventario i, Pagos p, Envios e, Facturacion f, Notificador n) {
        this.inventario = i;
        this.pagos = p;
        this.envios = e;
        this.facturacion = f;
        this.notificador = n;
    }

    public String comprar(SolicitudCompra s) {
        if (!inventario.reservar(s.sku(), s.cantidad())) {
            return "Sin stock";
        }
        long valor = PRECIO_UNITARIO * s.cantidad();
        if (!pagos.cobrar(s.tarjeta(), valor)) {
            inventario.liberar(s.sku(), s.cantidad()); // compensación en un solo lugar
            return "Pago rechazado";
        }
        String guia = envios.programar(s.cliente(), s.sku());
        String factura = facturacion.emitir(s.cliente(), valor);
        notificador.enviar(s.cliente(), "Compra OK " + factura + " guía " + guia);
        return "OK " + factura;
    }
}
