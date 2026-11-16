package edu.ingsoft.gof.estructurales.facade.problema;

public class Demo {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        System.out.println("Web:   " + new ControladorCompraWeb(inv)
                .comprar("ana", "SKU-1", 1, "4111"));
        System.out.println("Móvil: " + new ControladorCompraMovil(inv)
                .comprar("luis", "SKU-1", 2, "0000-rechazada"));
        System.out.println("Stock SKU-1 (debería ser 4): " + inv.disponible("SKU-1"));
    }
}
