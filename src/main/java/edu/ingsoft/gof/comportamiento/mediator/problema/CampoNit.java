package edu.ingsoft.gof.comportamiento.mediator.problema;

public class CampoNit {
    public String texto = "";
    public boolean habilitado;
    CasillaEmpresa casilla;
    CampoCorreo correo;
    BotonRegistrar boton;

    public void escribir(String t) {
        texto = t;
        // regla duplicada
        boton.habilitado = correo.texto.contains("@")
                && (!casilla.marcada || texto.length() >= 9);
    }
}
