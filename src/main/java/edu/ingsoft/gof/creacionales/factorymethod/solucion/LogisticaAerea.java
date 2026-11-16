package edu.ingsoft.gof.creacionales.factorymethod.solucion;

public class LogisticaAerea extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Dron();
    }
}
