package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

import java.util.Objects;

/** Client: solo conoce abstracciones; sin condicionales. */
public class PantallaPago {
    private final FabricaUI fabrica;

    public PantallaPago(FabricaUI fabrica) {
        this.fabrica = Objects.requireNonNull(fabrica);
    }

    public String dibujar() {
        CampoTexto tarjeta = fabrica.crearCampoTexto();
        Boton pagar = fabrica.crearBoton();
        return tarjeta.render("Tarjeta") + "\n" + pagar.render("Pagar");
    }
}
