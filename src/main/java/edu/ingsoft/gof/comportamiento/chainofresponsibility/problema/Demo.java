package edu.ingsoft.gof.comportamiento.chainofresponsibility.problema;

public class Demo {
    public static void main(String[] args) {
        ServicioAprobaciones s = new ServicioAprobaciones();
        long[] montos = {500_000, 7_000_000, 30_000_000, 90_000_000};
        for (long m : montos) {
            System.out.printf("%,14d -> %s%n", m, s.aprobar(new SolicitudCompra("PAPELERIA", m)));
        }
        System.out.println(s.aprobar(new SolicitudCompra("ACME-FRAUDE", 10)));
    }
}
