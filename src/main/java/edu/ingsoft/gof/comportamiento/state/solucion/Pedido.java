package edu.ingsoft.gof.comportamiento.state.solucion;

import java.util.ArrayList;
import java.util.List;

/** Context: delega en el estado actual. */
public class Pedido {
    private EstadoPedido estado = new Pendiente();
    private final List<String> historial = new ArrayList<>(List.of("PENDIENTE"));

    public void pagar() {
        estado.pagar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    void transicionar(EstadoPedido nuevo) {
        estado = nuevo;
        historial.add(nuevo.nombre());
    }

    public String estado() {
        return estado.nombre();
    }

    public List<String> historial() {
        return List.copyOf(historial);
    }
}
