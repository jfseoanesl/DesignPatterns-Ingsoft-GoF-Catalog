package edu.ingsoft.gof.comportamiento.iterator.problema;

public class Demo {
    public static void main(String[] args) {
        ListaReproduccion lista = new ListaReproduccion();
        String[] titulos = {"Colombia tierra querida", "La pollera colorá", "Matilde Lina",
                            "Oye mujer"};
        for (String t : titulos) {
            lista.agregar(new Cancion(t, t.startsWith("M")));
        }
        Reproductor r = new Reproductor();
        r.reproducirTodo(lista);
        r.reproducirAleatorio(lista);
        try {
            for (int i = 0; i < 10; i++) {
                lista.agregar(new Cancion("Extra " + i, false));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Desbordamiento: " + e.getMessage());
        }
    }
}
