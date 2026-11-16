package edu.ingsoft.gof.estructurales.adapter.solucion;

/** Adapter (de objetos): traduce entre el dominio y el protocolo XML. */
public class AdaptadorPasarelaXml implements ProcesadorPagos {
    private final PasarelaLegadaXml pasarela;

    public AdaptadorPasarelaXml(PasarelaLegadaXml pasarela) {
        this.pasarela = pasarela;
    }

    @Override
    public ResultadoPago cobrar(Pago pago) {
        return interpretar(pasarela.enviar(solicitud("COBRO", pago.cliente(), pago.valor())));
    }

    @Override
    public ResultadoPago reembolsar(String transaccion, long valor) {
        return interpretar(pasarela.enviar(solicitud("REEMBOLSO", transaccion, valor)));
    }

    private String solicitud(String op, String ref, long valor) {
        return "<solicitud><op>" + op + "</op><ref>" + ref
                + "</ref><valor>" + valor + "</valor></solicitud>";
    }

    private ResultadoPago interpretar(String xml) {
        return new ResultadoPago("OK".equals(etiqueta(xml, "estado")), etiqueta(xml, "tx"));
    }

    private static String etiqueta(String xml, String nombre) {
        int ini = xml.indexOf("<" + nombre + ">") + nombre.length() + 2;
        return xml.substring(ini, xml.indexOf("</" + nombre + ">"));
    }
}
