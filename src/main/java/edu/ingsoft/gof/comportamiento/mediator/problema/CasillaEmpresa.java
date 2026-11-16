package edu.ingsoft.gof.comportamiento.mediator.problema;

/** DEUDA TÉCNICA: conoce y manipula a los demás componentes. */
public class CasillaEmpresa {
    public boolean marcada;
    CampoNit nit;
    CampoCorreo correo;
    BotonRegistrar boton;

    public void marcar(boolean v) {
        marcada = v;
        nit.habilitado = v;
        boton.habilitado = correo.texto.contains("@") && (!v || nit.texto.length() >= 9);
    }
}
