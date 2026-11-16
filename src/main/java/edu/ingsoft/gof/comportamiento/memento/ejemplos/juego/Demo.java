package edu.ingsoft.gof.comportamiento.memento.ejemplos.juego;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Guardado de partida: el jugador restaura un punto de control. */
public class Demo {
    public static void main(String[] args) {
        Partida p = new Partida();
        p.recoger("espada");
        Map<String, Partida.PuntoControl> guardados = new HashMap<>();
        guardados.put("antes-del-jefe", p.guardar());

        p.recibirDano(120);
        p.recoger("poción");
        System.out.println("Tras la batalla: " + p);
        p.cargar(guardados.get("antes-del-jefe"));
        System.out.println("Cargado:         " + p);
    }
}

final class Partida {
    private int vida = 100;
    private int nivel = 3;
    private List<String> inventario = List.of();

    void recoger(String objeto) {
        inventario = new java.util.ArrayList<>(inventario);
        inventario.add(objeto);
        inventario = List.copyOf(inventario);
    }

    void recibirDano(int d) {
        vida = Math.max(0, vida - d);
    }

    PuntoControl guardar() {
        return new PuntoControl(vida, nivel, inventario);
    }

    void cargar(PuntoControl pc) {
        vida = pc.vida;
        nivel = pc.nivel;
        inventario = pc.inventario;
    }

    @Override
    public String toString() {
        return "vida=" + vida + " nivel=" + nivel + " inventario=" + inventario
                + (vida == 0 ? " (GAME OVER)" : "");
    }

    static final class PuntoControl {
        private final int vida;
        private final int nivel;
        private final List<String> inventario;

        private PuntoControl(int vida, int nivel, List<String> inventario) {
            this.vida = vida;
            this.nivel = nivel;
            this.inventario = List.copyOf(inventario);
        }
    }
}
