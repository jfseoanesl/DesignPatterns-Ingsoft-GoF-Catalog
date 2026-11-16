package edu.ingsoft.gof.estructurales.facade.solucion;

public class Notificador {
    public void enviar(String cliente, String mensaje) {
        System.out.println("  [notificación a " + cliente + "] " + mensaje);
    }
}
