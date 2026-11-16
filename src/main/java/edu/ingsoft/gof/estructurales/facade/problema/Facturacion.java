package edu.ingsoft.gof.estructurales.facade.problema;

public class Facturacion {
    public String emitir(String cliente, long valor) {
        return "FE-" + cliente.toUpperCase() + "-" + valor;
    }
}
