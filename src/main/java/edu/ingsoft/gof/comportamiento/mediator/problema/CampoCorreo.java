package edu.ingsoft.gof.comportamiento.mediator.problema;

public class CampoCorreo {
    public String texto = "";
    CasillaEmpresa casilla;
    CampoNit nit;
    BotonRegistrar boton;

    public void escribir(String t) {
        texto = t;
        // regla duplicada (otra vez)
        boton.habilitado = texto.contains("@") && (!casilla.marcada || nit.texto.length() >= 9);
    }
}
