package edu.ingsoft.gof.creacionales.singleton.problema;

public class Demo {
    public static void main(String[] args) {
        ServicioPedidos pedidos = new ServicioPedidos();
        ServicioReportes reportes = new ServicioReportes();
        new Configuracion(); // otra carga más
        pedidos.ajustarParaTemporadaAlta();
        System.out.println("Cargas del archivo: " + Configuracion.cargas);
        System.out.println("Pedidos ve " + pedidos.conexiones()
                + " conexiones; Reportes ve " + reportes.conexiones());
    }
}
