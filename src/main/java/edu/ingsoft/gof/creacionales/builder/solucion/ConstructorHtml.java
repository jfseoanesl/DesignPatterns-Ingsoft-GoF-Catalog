package edu.ingsoft.gof.creacionales.builder.solucion;

/** ConcreteBuilder: representación HTML. */
public class ConstructorHtml implements ConstructorReporte {
    private final StringBuilder html = new StringBuilder();
    private boolean tablaAbierta;

    @Override
    public void titulo(String texto) {
        html.append("<h1>").append(texto).append("</h1>\n");
    }

    @Override
    public void fila(String producto, double total) {
        if (!tablaAbierta) {
            html.append("<table>\n");
            tablaAbierta = true;
        }
        html.append(String.format("  <tr><td>%s</td><td>%.0f</td></tr>%n",
                                  producto, total));
    }

    @Override
    public void pie(String texto) {
        cerrarTabla();
        html.append("<footer>").append(texto).append("</footer>");
    }

    public String resultado() {
        cerrarTabla();
        return html.toString();
    }

    private void cerrarTabla() {
        if (tablaAbierta) {
            html.append("</table>\n");
            tablaAbierta = false;
        }
    }
}
