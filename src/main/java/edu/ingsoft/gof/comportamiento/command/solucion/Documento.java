package edu.ingsoft.gof.comportamiento.command.solucion;

/** Receiver. */
public class Documento {
    private final StringBuilder texto = new StringBuilder();

    public void insertar(String t) {
        texto.append(t);
    }

    /** Devuelve lo borrado para poder restaurarlo. */
    public String borrarUltimos(int n) {
        int desde = Math.max(0, texto.length() - n);
        String borrado = texto.substring(desde);
        texto.setLength(desde);
        return borrado;
    }

    /** Reemplaza todo el contenido y devuelve el anterior. */
    public String reemplazar(String nuevo) {
        String anterior = texto.toString();
        texto.setLength(0);
        texto.append(nuevo);
        return anterior;
    }

    public String contenido() {
        return texto.toString();
    }
}
