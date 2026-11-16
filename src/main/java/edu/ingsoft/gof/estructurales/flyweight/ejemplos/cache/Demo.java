package edu.ingsoft.gof.estructurales.flyweight.ejemplos.cache;

/** Flyweights del propio JDK: cachés de valores. */
public class Demo {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        Integer c = Integer.valueOf(1000);
        Integer d = Integer.valueOf(1000);
        System.out.println("valueOf(127) misma instancia:  " + (a == b));
        System.out.println("valueOf(1000) misma instancia: " + (c == d)
                + "  (fuera de la caché por defecto -128..127)");

        String s1 = "patron";
        String s2 = new String("patron");
        System.out.println("literal == new String:          " + (s1 == s2));
        System.out.println("literal == new String.intern(): " + (s1 == s2.intern()));
        System.out.println("Lección: comparar con equals(), nunca depender de la identidad.");
    }
}
