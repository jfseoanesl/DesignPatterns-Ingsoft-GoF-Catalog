package edu.ingsoft.gof.creacionales.factorymethod.solucion;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Logistica> modalidades = List.of(new LogisticaTerrestre(),
                new LogisticaMaritima(), new LogisticaAerea());
        double[] km = {120, 800, 5};
        for (int i = 0; i < modalidades.size(); i++) {
            System.out.println(modalidades.get(i).planificarEntrega(km[i]));
        }
    }
}
