package edu.ingsoft.gof.creacionales.factorymethod.solucion;

/** Nuevo producto: se agregó sin modificar código existente. */
public class Dron implements Transporte {
    @Override
    public String nombre() {
        return "Dron";
    }

    @Override
    public double costoPorKm() {
        return 4_000;
    }

    @Override
    public String despachar() {
        return "paquete asegurado y en vuelo";
    }
}
