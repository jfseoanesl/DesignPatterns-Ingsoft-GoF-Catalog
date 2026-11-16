package edu.ingsoft.gof.comportamiento.state.solucion;

public class Demo {
    public static void main(String[] args) {
        Pedido p = new Pedido();
        p.enviar();
        p.pagar();
        p.enviar();
        p.cancelar();
        p.entregar();
        System.out.println("Estado final: " + p.estado() + " | historial: " + p.historial());
    }
}
