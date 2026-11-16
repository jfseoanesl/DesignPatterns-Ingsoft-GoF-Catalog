package edu.ingsoft.gof.comportamiento.command.problema;

public class Documento {
    private final StringBuilder texto = new StringBuilder();

    public void insertar(String t) {
        texto.append(t);
    }

    public void borrarUltimos(int n) {
        texto.setLength(Math.max(0, texto.length() - n));
    }

    public void mayusculas() {
        String s = texto.toString().toUpperCase();
        texto.setLength(0);
        texto.append(s);
    }

    public String contenido() {
        return texto.toString();
    }
}
