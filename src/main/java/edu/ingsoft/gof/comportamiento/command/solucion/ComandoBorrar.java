package edu.ingsoft.gof.comportamiento.command.solucion;

public class ComandoBorrar implements Comando {
    private final Documento doc;
    private final int n;
    private String borrado = "";

    public ComandoBorrar(Documento doc, int n) {
        this.doc = doc;
        this.n = n;
    }

    @Override
    public void ejecutar() {
        borrado = doc.borrarUltimos(n);
    }

    @Override
    public void deshacer() {
        doc.insertar(borrado);
    }
}
