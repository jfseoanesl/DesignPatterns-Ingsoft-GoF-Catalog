package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

/** ConcreteFactory 2: solo produce componentes del tema oscuro. */
public final class FabricaTemaOscuro implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonOscuro();
    }

    @Override
    public CampoTexto crearCampoTexto() {
        return new CampoTextoOscuro();
    }

    private static final class BotonOscuro implements Boton {
        @Override
        public String render(String texto) {
            return "[ " + texto + " ] fondo=#121212 texto=#FFFFFF";
        }
    }

    private static final class CampoTextoOscuro implements CampoTexto {
        @Override
        public String render(String etiqueta) {
            return etiqueta + ": ________ borde=#444444";
        }
    }
}
