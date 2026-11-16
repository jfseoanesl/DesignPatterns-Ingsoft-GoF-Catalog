package edu.ingsoft.gof.comportamiento.state.ejemplos.semaforo;

/** Variante con enum: cada constante es un estado con su comportamiento. */
public class Demo {
    public static void main(String[] args) {
        Semaforo s = Semaforo.ROJO;
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-9s dura %2d s -> %s%n", s, s.duracion(), s.accion());
            s = s.siguiente();
        }
    }
}

enum Semaforo {
    ROJO(30) {
        @Override
        Semaforo siguiente() {
            return VERDE;
        }

        @Override
        String accion() {
            return "detenerse";
        }
    },
    VERDE(25) {
        @Override
        Semaforo siguiente() {
            return AMARILLO;
        }

        @Override
        String accion() {
            return "avanzar";
        }
    },
    AMARILLO(5) {
        @Override
        Semaforo siguiente() {
            return ROJO;
        }

        @Override
        String accion() {
            return "precaución";
        }
    };

    private final int duracion;

    Semaforo(int duracion) {
        this.duracion = duracion;
    }

    int duracion() {
        return duracion;
    }

    abstract Semaforo siguiente();

    abstract String accion();
}
