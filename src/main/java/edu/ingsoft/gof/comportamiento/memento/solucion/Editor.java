package edu.ingsoft.gof.comportamiento.memento.solucion;

/** Originator: crea y consume sus propias instantáneas. */
public class Editor {
    private String texto = "";
    private int cursor;
    private String fuente = "Arial";

    public void escribir(String t) {
        texto += t;
        cursor = texto.length();
    }

    public void cambiarFuente(String f) {
        fuente = f;
    }

    public Instantanea guardar() {
        return new Instantanea(texto, cursor, fuente);
    }

    public void restaurar(Instantanea m) {
        texto = m.texto;
        cursor = m.cursor;
        fuente = m.fuente;
    }

    @Override
    public String toString() {
        return "'" + texto + "' cursor=" + cursor + " fuente=" + fuente;
    }

    /** Memento: inmutable; su contenido solo es accesible para Editor. */
    public static final class Instantanea {
        private final String texto;
        private final int cursor;
        private final String fuente;

        private Instantanea(String texto, int cursor, String fuente) {
            this.texto = texto;
            this.cursor = cursor;
            this.fuente = fuente;
        }

        /** Interfaz estrecha: lo único que ve el cuidador. */
        public String etiqueta() {
            return texto.length() + " caracteres";
        }
    }
}
