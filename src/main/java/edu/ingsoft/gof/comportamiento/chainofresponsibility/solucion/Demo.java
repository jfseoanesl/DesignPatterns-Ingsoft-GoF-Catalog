package edu.ingsoft.gof.comportamiento.chainofresponsibility.solucion;

import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Aprobador cadena = Aprobador.cadena(
                new ValidadorProveedor(Set.of("ACME-FRAUDE")),
                new AprobadorPorMonto("Supervisor", 1_000_000),
                new AprobadorPorMonto("Gerente", 10_000_000),
                new AprobadorPorMonto("Director", 50_000_000),
                new AprobadorPorMonto("Vicepresidente", 80_000_000), // nuevo nivel
                new Comite());

        long[] montos = {500_000, 7_000_000, 30_000_000, 75_000_000, 90_000_000};
        for (long m : montos) {
            System.out.printf("%,14d -> %s%n", m,
                    cadena.manejar(new SolicitudCompra("PAPELERIA", m)));
        }
        System.out.println(cadena.manejar(new SolicitudCompra("ACME-FRAUDE", 10)));
    }
}
