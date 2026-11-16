package edu.ingsoft.gof.comportamiento.chainofresponsibility.ejemplos.soporte;

/** Mesa de ayuda por niveles con escalamiento. */
public class Demo {
    public static void main(String[] args) {
        Soporte mesa = new Bot(new NivelUno(new Especialista(null)));
        System.out.println(mesa.atender(new Ticket("Olvidé mi contraseña", 1)));
        System.out.println(mesa.atender(new Ticket("No puedo facturar", 2)));
        System.out.println(mesa.atender(new Ticket("Caída de la base de datos", 5)));
    }
}

record Ticket(String asunto, int complejidad) {
}

abstract class Soporte {
    private final Soporte siguiente;

    Soporte(Soporte siguiente) {
        this.siguiente = siguiente;
    }

    String atender(Ticket t) {
        if (resuelve(t)) {
            return nombre() + " resolvió: " + t.asunto();
        }
        return siguiente == null ? "Sin resolver: " + t.asunto()
                : nombre() + " escala -> " + siguiente.atender(t);
    }

    abstract boolean resuelve(Ticket t);

    abstract String nombre();
}

final class Bot extends Soporte {
    Bot(Soporte s) {
        super(s);
    }

    @Override
    boolean resuelve(Ticket t) {
        return t.complejidad() <= 1;
    }

    @Override
    String nombre() {
        return "Bot";
    }
}

final class NivelUno extends Soporte {
    NivelUno(Soporte s) {
        super(s);
    }

    @Override
    boolean resuelve(Ticket t) {
        return t.complejidad() <= 3;
    }

    @Override
    String nombre() {
        return "Nivel 1";
    }
}

final class Especialista extends Soporte {
    Especialista(Soporte s) {
        super(s);
    }

    @Override
    boolean resuelve(Ticket t) {
        return true;
    }

    @Override
    String nombre() {
        return "Especialista";
    }
}
