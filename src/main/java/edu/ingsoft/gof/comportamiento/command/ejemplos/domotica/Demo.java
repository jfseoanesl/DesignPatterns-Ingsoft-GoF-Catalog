package edu.ingsoft.gof.comportamiento.command.ejemplos.domotica;

import java.util.ArrayList;
import java.util.List;

/** Comandos domóticos y un macrocomando que se deshace en orden inverso. */
public class Demo {
    public static void main(String[] args) {
        Luz sala = new Luz("sala");
        Termostato termo = new Termostato();
        Comando modoNoche = new Macro(List.of(
                new ApagarLuz(sala), new FijarTemperatura(termo, 18)));
        modoNoche.ejecutar();
        System.out.println("Estado: " + sala + ", " + termo);
        modoNoche.deshacer();
        System.out.println("Deshecho: " + sala + ", " + termo);
    }
}

interface Comando {
    void ejecutar();

    void deshacer();
}

final class Luz {
    private final String lugar;
    boolean encendida = true;

    Luz(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "luz " + lugar + (encendida ? " ON" : " OFF");
    }
}

final class Termostato {
    int grados = 22;

    @Override
    public String toString() {
        return "termostato " + grados + "°C";
    }
}

final class ApagarLuz implements Comando {
    private final Luz luz;

    ApagarLuz(Luz l) {
        luz = l;
    }

    @Override
    public void ejecutar() {
        luz.encendida = false;
    }

    @Override
    public void deshacer() {
        luz.encendida = true;
    }
}

final class FijarTemperatura implements Comando {
    private final Termostato t;
    private final int objetivo;
    private int previa;

    FijarTemperatura(Termostato t, int objetivo) {
        this.t = t;
        this.objetivo = objetivo;
    }

    @Override
    public void ejecutar() {
        previa = t.grados;
        t.grados = objetivo;
    }

    @Override
    public void deshacer() {
        t.grados = previa;
    }
}

final class Macro implements Comando {
    private final List<Comando> pasos;

    Macro(List<Comando> pasos) {
        this.pasos = List.copyOf(pasos);
    }

    @Override
    public void ejecutar() {
        pasos.forEach(Comando::ejecutar);
    }

    @Override
    public void deshacer() {
        List<Comando> inverso = new ArrayList<>(pasos);
        java.util.Collections.reverse(inverso);
        inverso.forEach(Comando::deshacer);
    }
}
