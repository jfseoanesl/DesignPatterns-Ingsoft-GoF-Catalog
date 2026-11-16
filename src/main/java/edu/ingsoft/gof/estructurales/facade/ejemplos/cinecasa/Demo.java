package edu.ingsoft.gof.estructurales.facade.ejemplos.cinecasa;

/** Fachada de teatro en casa: una llamada coordina varios dispositivos. */
public class Demo {
    public static void main(String[] args) {
        TeatroEnCasa teatro = new TeatroEnCasa(new Luces(), new Proyector(),
                new Amplificador(), new Reproductor());
        teatro.verPelicula("Documental de la Amazonía");
        teatro.finalizar();
    }
}

final class Luces {
    void atenuar(int nivel) {
        System.out.println("Luces al " + nivel + "%");
    }
}

final class Proyector {
    void encender(boolean on) {
        System.out.println("Proyector " + (on ? "encendido (16:9)" : "apagado"));
    }
}

final class Amplificador {
    void configurar(String modo, int volumen) {
        System.out.println("Amplificador en " + modo + ", volumen " + volumen);
    }
}

final class Reproductor {
    void reproducir(String titulo) {
        System.out.println("Reproduciendo: " + titulo);
    }

    void detener() {
        System.out.println("Reproducción detenida");
    }
}

final class TeatroEnCasa {
    private final Luces luces;
    private final Proyector proyector;
    private final Amplificador amp;
    private final Reproductor reproductor;

    TeatroEnCasa(Luces l, Proyector p, Amplificador a, Reproductor r) {
        luces = l;
        proyector = p;
        amp = a;
        reproductor = r;
    }

    void verPelicula(String titulo) {
        luces.atenuar(10);
        proyector.encender(true);
        amp.configurar("sonido envolvente 5.1", 7);
        reproductor.reproducir(titulo);
    }

    void finalizar() {
        reproductor.detener();
        proyector.encender(false);
        luces.atenuar(100);
    }
}
