package edu.ingsoft.gof.comportamiento.memento.problema;

public class Demo {
    public static void main(String[] args) {
        Editor ed = new Editor();
        Historial h = new Historial();
        ed.escribir("Patrones ");
        h.guardar(ed);
        ed.escribir("GoF");
        ed.fuente = "Courier";
        System.out.println("Actual:   " + ed);
        h.deshacer(ed);
        System.out.println("Deshacer: " + ed + "   <- la fuente no se restauró");
    }
}
