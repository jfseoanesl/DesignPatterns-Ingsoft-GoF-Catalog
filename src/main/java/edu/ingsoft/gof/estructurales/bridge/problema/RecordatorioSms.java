package edu.ingsoft.gof.estructurales.bridge.problema;

public class RecordatorioSms extends Notificacion {
    @Override
    public String enviar(String destino, String texto) {
        String cuerpo = "Recordatorio: " + texto;
        String corto = cuerpo.length() > 30 ? cuerpo.substring(0, 30) : cuerpo; // duplicado
        return "SMS-GW -> " + destino + " | " + corto;
    }
}
