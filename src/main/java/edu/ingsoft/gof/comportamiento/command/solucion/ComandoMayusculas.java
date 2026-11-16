package edu.ingsoft.gof.comportamiento.command.solucion;

public class ComandoMayusculas implements Comando {
    private final Documento doc;
    private String anterior;

    public ComandoMayusculas(Documento doc) {
        this.doc = doc;
    }

    @Override
    public void ejecutar() {
        anterior = doc.reemplazar(doc.contenido().toUpperCase());
    }

    @Override
    public void deshacer() {
        doc.reemplazar(anterior);
    }
}
