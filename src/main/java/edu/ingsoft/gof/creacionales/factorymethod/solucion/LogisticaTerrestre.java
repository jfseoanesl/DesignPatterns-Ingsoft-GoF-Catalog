package edu.ingsoft.gof.creacionales.factorymethod.solucion;

public class LogisticaTerrestre extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Camion();
    }
}
