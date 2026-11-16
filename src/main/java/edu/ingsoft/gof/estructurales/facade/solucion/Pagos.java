package edu.ingsoft.gof.estructurales.facade.solucion;

public class Pagos {
    public boolean cobrar(String tarjeta, long valor) {
        return !tarjeta.startsWith("0000");
    }
}
