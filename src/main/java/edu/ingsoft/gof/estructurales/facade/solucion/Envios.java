package edu.ingsoft.gof.estructurales.facade.solucion;

public class Envios {
    public String programar(String cliente, String sku) {
        return "GUIA-" + Math.abs((cliente + sku).hashCode() % 10_000);
    }
}
