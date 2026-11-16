package edu.ingsoft.gof.estructurales.proxy.problema;

public class ConexionCostosa {
    public static int creadas = 0;

    public ConexionCostosa() {
        creadas++; // simula abrir conexiones al data warehouse
    }

    public String consultar(String periodo) {
        return "Ingresos " + periodo + ": $1.250M | Gastos: $980M";
    }
}
