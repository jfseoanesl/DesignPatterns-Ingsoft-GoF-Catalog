package edu.ingsoft.gof.comportamiento.command.solucion;

public class Demo {
    public static void main(String[] args) {
        Documento doc = new Documento();
        Historial h = new Historial();
        Boton mayus = new Boton("MAYÚS", () -> new ComandoMayusculas(doc), h);

        h.ejecutar(new ComandoEscribir(doc, "Hola "));
        h.ejecutar(new ComandoEscribir(doc, "mundo"));
        mayus.clic();
        System.out.println("Tras ejecutar:   " + doc.contenido());
        h.deshacer();
        System.out.println("Deshacer:        " + doc.contenido());
        h.ejecutar(new ComandoBorrar(doc, 5));
        System.out.println("Borrar 5:        " + doc.contenido());
        h.deshacer();
        System.out.println("Deshacer:        " + doc.contenido());
        h.rehacer();
        System.out.println("Rehacer:         " + doc.contenido());
    }
}
