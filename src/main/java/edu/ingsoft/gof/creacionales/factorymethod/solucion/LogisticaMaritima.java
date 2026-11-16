package edu.ingsoft.gof.creacionales.factorymethod.solucion;

public class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Barco();
    }
}
