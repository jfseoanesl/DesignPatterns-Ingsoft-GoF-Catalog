package edu.ingsoft.gof.creacionales.builder.problema;

import java.util.List;

/** DEUDA TÉCNICA: algoritmo de armado y formato de salida en un solo método. */
public class GeneradorReporte {

    public String generar(String formato, String titulo, List<String[]> filas,
                          String pie) {
        StringBuilder sb = new StringBuilder();
        if (formato.equals("html")) {
            sb.append("<h1>").append(titulo).append("</h1>\n<table>\n");
        } else if (formato.equals("texto")) {
            sb.append(titulo.toUpperCase()).append('\n');
            sb.append("=".repeat(titulo.length())).append('\n');
        }
        for (String[] f : filas) {
            if (formato.equals("html")) {
                sb.append("  <tr><td>").append(f[0]).append("</td><td>")
                  .append(f[1]).append("</td></tr>\n");
            } else if (formato.equals("texto")) {
                sb.append(String.format("%-12s %10s%n", f[0], f[1]));
            }
        }
        if (formato.equals("html")) {
            sb.append("</table>\n");
        }
        if (pie != null) {
            if (formato.equals("html")) {
                sb.append("<footer>").append(pie).append("</footer>");
            } else if (formato.equals("texto")) {
                sb.append("-".repeat(23)).append('\n').append(pie);
            }
        }
        return sb.toString();
    }
}
