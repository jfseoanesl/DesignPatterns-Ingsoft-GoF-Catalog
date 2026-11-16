package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

/** ConcreteFactory 1: solo produce componentes del tema claro. */
public final class FabricaTemaClaro implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonClaro();
    }

    @Override
    public CampoTexto crearCampoTexto() {
        return new CampoTextoClaro();
    }

    private static final class BotonClaro implements Boton {
        @Override
        public String render(String texto) {
            return "[ " + texto + " ] fondo=#FFFFFF texto=#000000";
        }
    }

    private static final class CampoTextoClaro implements CampoTexto {
        @Override
        public String render(String etiqueta) {
            return etiqueta + ": ________ borde=#CCCCCC";
        }
    }
}
