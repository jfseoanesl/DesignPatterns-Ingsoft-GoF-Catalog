package edu.ingsoft.gof.estructurales.proxy.solucion;

public class Demo {
    public static void main(String[] args) {
        ServicioReportes servicio = new ProxyProteccion(
                new ProxyCache(ServicioReportesReal::new), "GERENTE");
        System.out.println("Instancias reales antes de usar: "
                + ServicioReportesReal.instancias);

        Usuario gerente = new Usuario("Marta", "GERENTE");
        servicio.consolidado(gerente, "2026-10");
        System.out.println(servicio.consolidado(gerente, "2026-10"));
        try {
            servicio.consolidado(new Usuario("Juan", "ANALISTA"), "2026-10");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Instancias reales: " + ServicioReportesReal.instancias
                + " | consultas reales: " + ServicioReportesReal.consultas);
    }
}
