package edu.ingsoft.gof.comportamiento.mediator.solucion;

/** ConcreteMediator: toda la política de coordinación en un solo lugar. */
public final class DialogoRegistro implements MediadorFormulario {
    private final CasillaEmpresa casilla = new CasillaEmpresa();
    private final CampoTexto nit = new CampoTexto();
    private final CampoTexto correo = new CampoTexto();
    private final Boton registrar = new Boton();

    public DialogoRegistro() {
        for (Componente c : new Componente[] {casilla, nit, correo, registrar}) {
            c.setMediador(this);
        }
        nit.habilitar(false);
    }

    @Override
    public void notificar(Componente emisor, String evento) {
        if (emisor == casilla) {
            nit.habilitar(casilla.marcada());
        }
        registrar.habilitar(formularioValido());
    }

    private boolean formularioValido() {
        boolean correoOk = correo.texto().contains("@");
        boolean nitOk = !casilla.marcada() || nit.texto().length() >= 9;
        return correoOk && nitOk;
    }

    public CasillaEmpresa casilla() {
        return casilla;
    }

    public CampoTexto nit() {
        return nit;
    }

    public CampoTexto correo() {
        return correo;
    }

    public Boton registrar() {
        return registrar;
    }
}
