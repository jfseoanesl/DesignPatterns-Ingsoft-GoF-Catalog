package edu.ingsoft.gof.creacionales.prototype.problema;

/** DEUDA TÉCNICA: el editor sabe cómo copiar cada clase concreta. */
public class EditorDiagramas {

    public Object duplicar(Object f) {
        if (f instanceof Circulo c) {
            Circulo n = new Circulo();
            n.x = c.x;
            n.y = c.y;
            n.radio = c.radio;
            return n;
        } else if (f instanceof Rectangulo r) {
            Rectangulo n = new Rectangulo();
            n.x = r.x;
            n.y = r.y;
            n.ancho = r.ancho;
            n.alto = r.alto;
            return n;
        } else if (f instanceof Grupo g) {
            Grupo n = new Grupo();
            n.hijos = g.hijos; // copia superficial: ¡comparten la lista!
            return n;
        }
        return null; // figura desconocida: falla en silencio
    }
}
