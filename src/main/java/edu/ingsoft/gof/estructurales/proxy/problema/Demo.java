package edu.ingsoft.gof.estructurales.proxy.problema;

public class Demo {
    public static void main(String[] args) {
        ServicioReportes s = new ServicioReportes();
        System.out.println("Conexiones creadas sin usar el servicio: "
                + ConexionCostosa.creadas);
        Usuario gerente = new Usuario("Marta", "GERENTE");
        s.consolidado(gerente, "2026-10");
        System.out.println(s.consolidado(gerente, "2026-10"));
        try {
            s.consolidado(new Usuario("Juan", "ANALISTA"), "2026-10");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Consultas reales: " + s.consultasReales());
    }
}
