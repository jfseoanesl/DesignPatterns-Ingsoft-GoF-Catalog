package edu.ingsoft.gof.creacionales.factorymethod.solucion;

public class Camion implements Transporte {
    @Override
    public String nombre() {
        return "Camión";
    }

    @Override
    public double costoPorKm() {
        return 2_500;
    }

    @Override
    public String despachar() {
        return "cargado en bodega";
    }
}
