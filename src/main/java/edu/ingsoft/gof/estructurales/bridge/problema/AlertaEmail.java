package edu.ingsoft.gof.estructurales.bridge.problema;

public class AlertaEmail extends Notificacion {
    @Override
    public String enviar(String destino, String texto) {
        String cuerpo = "⚠ ALERTA: " + texto.toUpperCase();
        return "SMTP -> " + destino + " | " + cuerpo;
    }
}
