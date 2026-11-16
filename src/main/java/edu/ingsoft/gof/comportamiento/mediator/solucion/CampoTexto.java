package edu.ingsoft.gof.comportamiento.mediator.solucion;

/** Reutilizable en cualquier formulario. */
public class CampoTexto extends Componente {
    private String texto = "";
    private boolean habilitado = true;

    public void escribir(String t) {
        texto = t;
        cambio("texto");
    }

    public String texto() {
        return texto;
    }

    public void habilitar(boolean v) {
        habilitado = v;
    }

    public boolean habilitado() {
        return habilitado;
    }
}
