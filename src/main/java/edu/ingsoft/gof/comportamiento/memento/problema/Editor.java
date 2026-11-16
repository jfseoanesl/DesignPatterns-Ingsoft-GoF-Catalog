package edu.ingsoft.gof.comportamiento.memento.problema;

/** DEUDA TÉCNICA: estado interno público para que otros lo copien. */
public class Editor {
    public String texto = "";
    public int cursor;
    public String fuente = "Arial"; // agregado después: el historial no lo conoce

    public void escribir(String t) {
        texto += t;
        cursor = texto.length();
    }

    @Override
    public String toString() {
        return "'" + texto + "' cursor=" + cursor + " fuente=" + fuente;
    }
}
