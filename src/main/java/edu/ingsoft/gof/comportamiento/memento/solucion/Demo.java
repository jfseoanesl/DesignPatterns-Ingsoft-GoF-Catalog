package edu.ingsoft.gof.comportamiento.memento.solucion;

public class Demo {
    public static void main(String[] args) {
        Editor ed = new Editor();
        Historial h = new Historial(ed);
        ed.escribir("Patrones ");
        h.respaldar();
        ed.escribir("GoF");
        ed.cambiarFuente("Courier");
        System.out.println("Actual:   " + ed);
        h.deshacer();
        System.out.println("Deshacer: " + ed + "   <- estado completo restaurado");
    }
}
