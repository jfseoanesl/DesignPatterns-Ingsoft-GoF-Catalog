package edu.ingsoft.gof.estructurales.composite.solucion;

public class Demo {
    public static void main(String[] args) {
        Departamento soporte = new Departamento("Soporte")
                .agregar(new Empleado("Luis", "Analista N1", 4_000_000))
                .agregar(new Empleado("Sara", "Analista N2", 5_200_000));
        Departamento ti = new Departamento("TI")
                .agregar(new Empleado("Ana", "Arquitecta", 9_000_000))
                .agregar(soporte);

        ServicioNomina nomina = new ServicioNomina();
        System.out.println(nomina.reporte(ti));
        System.out.println(nomina.reporte(new Empleado("Pedro", "Pasante", 1_400_000)));
    }
}
