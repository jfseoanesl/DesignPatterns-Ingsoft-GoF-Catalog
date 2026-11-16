package edu.ingsoft.gof.creacionales.abstractfactory.problema;

/** DEUDA TÉCNICA: el cliente decide la familia en cada punto de creación. */
public class PantallaPago {
    private final String tema;

    public PantallaPago(String tema) {
        this.tema = tema;
    }

    public String dibujar() {
        StringBuilder sb = new StringBuilder();
        // Decisión repetida #1
        if (tema.equals("claro")) {
            sb.append(new CampoTextoClaro().render("Tarjeta")).append('\n');
        } else {
            sb.append(new CampoTextoOscuro().render("Tarjeta")).append('\n');
        }
        // Decisión repetida #2: ¿qué pasa con "Oscuro" o "alto-contraste"?
        if (tema.equals("oscuro")) {
            sb.append(new BotonOscuro().render("Pagar"));
        } else {
            sb.append(new BotonClaro().render("Pagar")); // ¡mezcla familias!
        }
        return sb.toString();
    }
}
