package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

/** AbstractFactory: crea una familia completa de componentes compatibles. */
public interface FabricaUI {
    Boton crearBoton();

    CampoTexto crearCampoTexto();
}
