package edu.ingsoft.gof.creacionales.prototype.solucion;

/** Cliente: duplica cualquier figura sin conocer su clase concreta. */
public class EditorDiagramas {

    public Figura duplicar(Figura f) {
        Figura copia = f.copiar();
        copia.mover(20, 20); // desplaza el duplicado para que sea visible
        return copia;
    }
}
