package edu.ingsoft.gof.estructurales.adapter.solucion;

/** Adaptee: código de un tercero, sin cambios. */
public class PasarelaLegadaXml {
    private int secuencia = 1000;

    public String enviar(String xml) {
        boolean ok = !xml.contains("<valor>0</valor>");
        return "<respuesta><estado>" + (ok ? "OK" : "RECHAZADO")
                + "</estado><tx>TX" + (secuencia++) + "</tx></respuesta>";
    }
}
