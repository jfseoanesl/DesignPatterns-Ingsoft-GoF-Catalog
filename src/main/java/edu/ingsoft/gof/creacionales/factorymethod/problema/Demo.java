package edu.ingsoft.gof.creacionales.factorymethod.problema;

public class Demo {
    public static void main(String[] args) {
        ServicioEntregas s = new ServicioEntregas();
        System.out.println(s.planificarEntrega("camion", 120));
        System.out.println(s.planificarEntrega("barco", 800));
        try {
            System.out.println(s.planificarEntrega("dron", 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Error en ejecución: " + e.getMessage());
        }
    }
}
