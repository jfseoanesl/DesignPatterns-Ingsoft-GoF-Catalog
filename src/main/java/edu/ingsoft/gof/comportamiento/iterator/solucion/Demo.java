package edu.ingsoft.gof.comportamiento.iterator.solucion;

public class Demo {
    public static void main(String[] args) {
        ListaReproduccion lista = new ListaReproduccion();
        String[] titulos = {"Colombia tierra querida", "La pollera colorá", "Matilde Lina",
                            "Oye mujer"};
        for (String t : titulos) {
            lista.agregar(new Cancion(t, t.startsWith("M") || t.startsWith("O")));
        }
        for (int i = 0; i < 10; i++) {
            lista.agregar(new Cancion("Extra " + i, false)); // sin límite fijo
        }
        Reproductor r = new Reproductor();
        System.out.println("Favoritas: " + r.reproducir(lista.favoritas()));
        System.out.println("Aleatorio: " + r.reproducir(lista.aleatorio(7))
                .substring(0, 60) + "...");
        int n = 0;
        for (Cancion ignored : lista) {
            n++;
        }
        System.out.println("Total recorrido con for-each: " + n);
    }
}
