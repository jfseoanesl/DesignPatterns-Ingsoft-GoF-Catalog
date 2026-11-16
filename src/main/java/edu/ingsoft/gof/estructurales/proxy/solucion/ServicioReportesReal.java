package edu.ingsoft.gof.estructurales.proxy.solucion;

/** RealSubject: solo lógica de negocio. */
public class ServicioReportesReal implements ServicioReportes {
    static int instancias = 0;
    static int consultas = 0;

    public ServicioReportesReal() {
        instancias++; // abre conexiones costosas
    }

    @Override
    public String consolidado(Usuario usuario, String periodo) {
        consultas++;
        return "Ingresos " + periodo + ": $1.250M | Gastos: $980M";
    }
}
