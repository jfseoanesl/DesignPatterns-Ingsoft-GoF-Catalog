package edu.ingsoft.gof.estructurales.adapter.problema;

/** DEUDA TÉCNICA: el caso de uso conoce el protocolo XML de la pasarela. */
public class ServicioCheckout {
    private final PasarelaLegadaXml pasarela = new PasarelaLegadaXml();

    public String cobrar(String cliente, long valor) {
        String xml = "<solicitud><op>COBRO</op><ref>" + cliente
                + "</ref><valor>" + valor + "</valor></solicitud>";
        String r = pasarela.enviar(xml);
        String estado = r.substring(r.indexOf("<estado>") + 8, r.indexOf("</estado>"));
        String tx = r.substring(r.indexOf("<tx>") + 4, r.indexOf("</tx>"));
        return estado.equals("OK") ? "Cobro aprobado " + tx : "Cobro rechazado";
    }

    public String reembolsar(String transaccion, long valor) {
        // Mismo armado y análisis, copiado y pegado
        String xml = "<solicitud><op>REEMBOLSO</op><ref>" + transaccion
                + "</ref><valor>" + valor + "</valor></solicitud>";
        String r = pasarela.enviar(xml);
        String estado = r.substring(r.indexOf("<estado>") + 8, r.indexOf("</estado>"));
        return estado.equals("OK") ? "Reembolso aprobado" : "Reembolso rechazado";
    }
}
