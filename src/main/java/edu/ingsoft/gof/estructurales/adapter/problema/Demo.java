package edu.ingsoft.gof.estructurales.adapter.problema;

public class Demo {
    public static void main(String[] args) {
        ServicioCheckout checkout = new ServicioCheckout();
        System.out.println(checkout.cobrar("cliente-7", 150_000));
        System.out.println(checkout.cobrar("cliente-8", 0));
        System.out.println(checkout.reembolsar("TX1000", 150_000));
    }
}
