package edu.ingsoft.gof.comportamiento.chainofresponsibility.solucion;

/** Eslabón configurable: un cargo con un límite de aprobación. */
public class AprobadorPorMonto extends Aprobador {
    private final String cargo;
    private final long limite;

    public AprobadorPorMonto(String cargo, long limite) {
        this.cargo = cargo;
        this.limite = limite;
    }

    @Override
    protected boolean puedeResolver(SolicitudCompra s) {
        return s.monto() <= limite;
    }

    @Override
    protected String resolver(SolicitudCompra s) {
        return "Aprobada por " + cargo;
    }
}
