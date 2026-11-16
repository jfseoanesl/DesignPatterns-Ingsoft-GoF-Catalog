package edu.ingsoft.gof.estructurales.composite.problema;

/** DEUDA TÉCNICA: el cliente distingue hojas y contenedores con instanceof. */
public class ServicioNomina {

    public double costo(Object nodo) {
        if (nodo instanceof Empleado e) {
            return e.salario;
        } else if (nodo instanceof Departamento d) {
            double total = 0;
            for (Object m : d.miembros) {
                total += costo(m); // recorrido #1
            }
            return total;
        }
        throw new IllegalArgumentException("Nodo desconocido");
    }

    public void imprimir(Object nodo, int nivel) {
        String sangria = "  ".repeat(nivel);
        if (nodo instanceof Empleado e) {
            System.out.println(sangria + "- " + e.nombre);
        } else if (nodo instanceof Departamento d) {
            System.out.println(sangria + "+ " + d.nombre);
            for (Object m : d.miembros) {
                imprimir(m, nivel + 1); // recorrido #2 (duplicado)
            }
        }
    }
}
