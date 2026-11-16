package edu.ingsoft.gof.estructurales.facade.solucion;

public class Demo {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        FachadaCompras fachada = new FachadaCompras(inv, new Pagos(), new Envios(),
                new Facturacion(), new Notificador());
        System.out.println("Web:   " + new ControladorCompraWeb(fachada)
                .comprar("ana", "SKU-1", 1, "4111"));
        System.out.println("Móvil: " + new ControladorCompraMovil(fachada)
                .comprar("luis", "SKU-1", 2, "0000-rechazada"));
        System.out.println("Stock SKU-1 (debería ser 4): " + inv.disponible("SKU-1"));
    }
}
