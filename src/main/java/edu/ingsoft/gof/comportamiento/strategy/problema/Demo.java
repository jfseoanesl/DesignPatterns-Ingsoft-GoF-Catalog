package edu.ingsoft.gof.comportamiento.strategy.problema;

public class Demo {
    public static void main(String[] args) {
        for (String m : new String[] {"estandar", "expres", "tienda", "internacional"}) {
            System.out.printf("%-14s total: $%,12.0f%n", m, new Carrito(200_000, 2.5, m).total());
        }
        try {
            new Carrito(200_000, 2.5, "verde").total();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " -> hay que modificar el switch");
        }
    }
}
