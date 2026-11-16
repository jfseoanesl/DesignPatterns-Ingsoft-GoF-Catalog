package edu.ingsoft.gof.comportamiento.command.solucion;

import java.util.function.Supplier;

/** Invoker de interfaz: configurado con un comando, sin switch. */
public class Boton {
    private final String etiqueta;
    private final Supplier<Comando> comando;
    private final Historial historial;

    public Boton(String etiqueta, Supplier<Comando> comando, Historial historial) {
        this.etiqueta = etiqueta;
        this.comando = comando;
        this.historial = historial;
    }

    public void clic() {
        historial.ejecutar(comando.get()); // instancia nueva por clic (guarda su estado)
    }

    public String etiqueta() {
        return etiqueta;
    }
}
