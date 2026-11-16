package edu.ingsoft.gof.estructurales.flyweight.problema;

public class Demo {
    public static void main(String[] args) {
        String[][] especies = {{"Guayacán", "amarillo"}, {"Ceiba", "verde"},
                               {"Yarumo", "plateado"}};
        Bosque bosque = new Bosque();
        for (int i = 0; i < 100_000; i++) {
            String[] e = especies[i % 3];
            bosque.plantar(i % 500, i / 500, e[0], e[1]);
        }
        System.out.printf("Árboles: %,d | memoria en texturas: %,.1f MB%n",
                bosque.cantidad(), bosque.bytesTexturas() / 1048576.0);
    }
}
