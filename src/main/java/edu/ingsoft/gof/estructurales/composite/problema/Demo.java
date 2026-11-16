package edu.ingsoft.gof.estructurales.composite.problema;

public class Demo {
    public static void main(String[] args) {
        Departamento ti = new Departamento("TI");
        ti.miembros.add(new Empleado("Ana", 9_000_000));
        Departamento soporte = new Departamento("Soporte");
        soporte.miembros.add(new Empleado("Luis", 4_000_000));
        ti.miembros.add(soporte);
        ti.miembros.add("texto suelto"); // la lista sin tipo admite cualquier cosa

        ServicioNomina nomina = new ServicioNomina();
        nomina.imprimir(ti, 0);
        try {
            System.out.println("Costo: " + nomina.costo(ti));
        } catch (IllegalArgumentException ex) {
            System.out.println("Falla en ejecución: " + ex.getMessage());
        }
    }
}
