package edu.ingsoft.gof.estructurales.bridge.solucion;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        CanalEnvio sms = new CanalSms();
        CanalEnvio whatsapp = new CanalWhatsApp();
        LocalDate manana = LocalDate.of(2026, 11, 17);

        System.out.println(new Alerta(new CanalEmail()).enviar("ops@tienda.co",
                "servidor caído"));
        System.out.println(new Alerta(sms).enviar("3001234567", "servidor caído"));
        System.out.println(new Recordatorio(whatsapp, manana).enviar("3001234567",
                "su cita es a las 9:00"));
        System.out.println("Clases necesarias para 2 tipos + 3 canales: " + (2 + 3));
    }
}
