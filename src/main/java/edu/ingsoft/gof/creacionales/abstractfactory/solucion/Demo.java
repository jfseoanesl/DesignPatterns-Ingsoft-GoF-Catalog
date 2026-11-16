package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

public class Demo {
    public static void main(String[] args) {
        // Raíz de composición: único lugar donde se elige la familia.
        for (Tema tema : Tema.values()) {
            System.out.println("== " + tema + " ==");
            System.out.println(new PantallaPago(tema.fabrica()).dibujar());
        }
    }
}
