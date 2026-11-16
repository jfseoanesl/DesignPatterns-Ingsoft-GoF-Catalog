package edu.ingsoft.gof.estructurales.facade.problema;

public class Pagos {
    public boolean cobrar(String tarjeta, long valor) {
        return !tarjeta.startsWith("0000");
    }
}
