package edu.ingsoft.gof.estructurales.facade.problema;

/** DEUDA TÉCNICA: el cliente orquesta todo el subsistema. */
public class ControladorCompraWeb {
    private final Inventario inventario;
    private final Pagos pagos = new Pagos();
    private final Envios envios = new Envios();
    private final Facturacion facturacion = new Facturacion();
    private final Notificador notificador = new Notificador();

    public ControladorCompraWeb(Inventario inventario) {
        this.inventario = inventario;
    }

    public String comprar(String cliente, String sku, int cantidad, String tarjeta) {
        if (!inventario.reservar(sku, cantidad)) {
            return "Sin stock";
        }
        long valor = 50_000L * cantidad;
        if (!pagos.cobrar(tarjeta, valor)) {
            inventario.liberar(sku, cantidad); // compensación
            return "Pago rechazado";
        }
        String guia = envios.programar(cliente, sku);
        String factura = facturacion.emitir(cliente, valor);
        notificador.enviar(cliente, "Compra OK " + factura + " guía " + guia);
        return "OK " + factura;
    }
}
