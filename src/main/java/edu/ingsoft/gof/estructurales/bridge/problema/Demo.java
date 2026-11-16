package edu.ingsoft.gof.estructurales.bridge.problema;

public class Demo {
    public static void main(String[] args) {
        System.out.println(new AlertaEmail().enviar("ops@tienda.co", "servidor caído"));
        System.out.println(new AlertaSms().enviar("3001234567", "servidor caído"));
        System.out.println(new RecordatorioSms().enviar("3001234567",
                "su cita es mañana a las 9:00"));
        System.out.println("Clases necesarias para 2 tipos × 3 canales: " + 2 * 3);
    }
}
