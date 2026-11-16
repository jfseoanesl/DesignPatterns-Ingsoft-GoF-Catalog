package edu.ingsoft.gof.estructurales.bridge.problema;

public class RecordatorioEmail extends Notificacion {
    @Override
    public String enviar(String destino, String texto) {
        String cuerpo = "Recordatorio: " + texto;
        return "SMTP -> " + destino + " | " + cuerpo; // duplicado
    }
}
