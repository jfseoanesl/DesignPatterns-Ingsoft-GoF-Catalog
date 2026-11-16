package edu.ingsoft.gof.comportamiento.command.solucion;

public class ComandoEscribir implements Comando {
    private final Documento doc;
    private final String texto;

    public ComandoEscribir(Documento doc, String texto) {
        this.doc = doc;
        this.texto = texto;
    }

    @Override
    public void ejecutar() {
        doc.insertar(texto);
    }

    @Override
    public void deshacer() {
        doc.borrarUltimos(texto.length());
    }
}
