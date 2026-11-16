package edu.ingsoft.gof.estructurales.bridge.problema;

public class AlertaSms extends Notificacion {
    @Override
    public String enviar(String destino, String texto) {
        String cuerpo = "⚠ ALERTA: " + texto.toUpperCase(); // duplicado
        String corto = cuerpo.length() > 30 ? cuerpo.substring(0, 30) : cuerpo;
        return "SMS-GW -> " + destino + " | " + corto;
    }
}
