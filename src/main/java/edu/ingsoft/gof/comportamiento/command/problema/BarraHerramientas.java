package edu.ingsoft.gof.comportamiento.command.problema;

/** DEUDA TÉCNICA: el invocador conoce al receptor y cada operación. */
public class BarraHerramientas {
    private final Documento doc;

    public BarraHerramientas(Documento doc) {
        this.doc = doc;
    }

    public void clic(String boton, String arg) {
        switch (boton) {
            case "escribir" -> doc.insertar(arg);
            case "borrar" -> doc.borrarUltimos(Integer.parseInt(arg));
            case "mayus" -> doc.mayusculas();
            default -> throw new IllegalArgumentException(boton);
        }
    }
}
