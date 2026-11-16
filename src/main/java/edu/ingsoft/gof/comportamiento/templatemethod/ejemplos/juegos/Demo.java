package edu.ingsoft.gof.comportamiento.templatemethod.ejemplos.juegos;

/** El esqueleto de un juego por turnos es común a todos los juegos. */
public class Demo {
    public static void main(String[] args) {
        new Ajedrez().jugar(2);
        System.out.println();
        new Parques().jugar(4);
    }
}

abstract class JuegoPorTurnos {
    private int turno;

    final void jugar(int jugadores) {
        inicializar(jugadores);
        while (!terminado()) {
            jugarTurno(turno % jugadores);
            turno++;
        }
        anunciarGanador();
    }

    protected int turno() {
        return turno;
    }

    protected abstract void inicializar(int jugadores);

    protected abstract void jugarTurno(int jugador);

    protected abstract boolean terminado();

    protected void anunciarGanador() { // gancho con comportamiento por defecto
        System.out.println("Fin del juego tras " + turno + " turnos");
    }
}

final class Ajedrez extends JuegoPorTurnos {
    @Override
    protected void inicializar(int jugadores) {
        System.out.println("Ajedrez: piezas en posición inicial");
    }

    @Override
    protected void jugarTurno(int jugador) {
        System.out.println("  " + (jugador == 0 ? "Blancas" : "Negras") + " mueven");
    }

    @Override
    protected boolean terminado() {
        return turno() >= 4;
    }

    @Override
    protected void anunciarGanador() {
        System.out.println("Jaque mate: ganan las negras");
    }
}

final class Parques extends JuegoPorTurnos {
    private final int[] posiciones = new int[4];
    private final java.util.Random dado = new java.util.Random(3);

    @Override
    protected void inicializar(int jugadores) {
        System.out.println("Parqués: fichas en la cárcel");
    }

    @Override
    protected void jugarTurno(int j) {
        posiciones[j] += 1 + dado.nextInt(6);
    }

    @Override
    protected boolean terminado() {
        for (int p : posiciones) {
            if (p >= 20) {
                return true;
            }
        }
        return false;
    }
}
