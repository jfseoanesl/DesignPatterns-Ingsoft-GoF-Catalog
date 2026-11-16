package edu.ingsoft.gof.creacionales.factorymethod.solucion;

public class Barco implements Transporte {
    @Override
    public String nombre() {
        return "Barco";
    }

    @Override
    public double costoPorKm() {
        return 900;
    }

    @Override
    public String despachar() {
        return "contenedor embarcado en puerto";
    }
}
