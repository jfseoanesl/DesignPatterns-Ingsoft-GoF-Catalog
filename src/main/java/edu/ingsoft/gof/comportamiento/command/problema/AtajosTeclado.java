package edu.ingsoft.gof.comportamiento.command.problema;

/** DEUDA TÉCNICA: el mismo switch, duplicado. */
public class AtajosTeclado {
    private final Documento doc;

    public AtajosTeclado(Documento doc) {
        this.doc = doc;
    }

    public void presionar(String atajo, String arg) {
        switch (atajo) {
            case "Ctrl+V" -> doc.insertar(arg);
            case "Backspace" -> doc.borrarUltimos(Integer.parseInt(arg));
            case "Ctrl+Shift+U" -> doc.mayusculas();
            // "Ctrl+Z" (deshacer): imposible, no hay registro de lo ejecutado
            default -> throw new IllegalArgumentException(atajo);
        }
    }
}
