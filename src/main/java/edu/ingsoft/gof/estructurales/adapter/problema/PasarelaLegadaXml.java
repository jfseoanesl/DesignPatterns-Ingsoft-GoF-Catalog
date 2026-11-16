package edu.ingsoft.gof.estructurales.adapter.problema;

/** Código de un tercero: NO se puede modificar. */
public class PasarelaLegadaXml {
    private int secuencia = 1000;

    public String enviar(String xml) {
        boolean ok = !xml.contains("<valor>0</valor>");
        return "<respuesta><estado>" + (ok ? "OK" : "RECHAZADO")
                + "</estado><tx>TX" + (secuencia++) + "</tx></respuesta>";
    }
}
