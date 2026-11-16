package edu.ingsoft.gof.comportamiento.chainofresponsibility.ejemplos.middleware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Pipeline de middleware: cada eslabón decide si continúa. */
public class Demo {
    public static void main(String[] args) {
        Middleware cadena = Middleware.enlazar(List.of(
                new Registro(), new Autenticacion(), new LimitePeticiones(2)));
        Manejador app = req -> "200 OK: " + req.ruta();
        List<Peticion> peticiones = List.of(
                new Peticion("/pedidos", "token-valido"),
                new Peticion("/pedidos", null),
                new Peticion("/pedidos", "token-valido"),
                new Peticion("/pedidos", "token-valido"));
        for (Peticion p : peticiones) {
            System.out.println(cadena.procesar(p, app));
        }
    }
}

record Peticion(String ruta, String token) {
}

interface Manejador {
    String atender(Peticion p);
}

abstract class Middleware {
    private Middleware siguiente;

    static Middleware enlazar(List<Middleware> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            lista.get(i).siguiente = lista.get(i + 1);
        }
        return lista.get(0);
    }

    abstract String procesar(Peticion p, Manejador destino);

    protected String continuar(Peticion p, Manejador destino) {
        return siguiente == null ? destino.atender(p) : siguiente.procesar(p, destino);
    }
}

final class Registro extends Middleware {
    @Override
    String procesar(Peticion p, Manejador d) {
        System.out.print("[log " + p.ruta() + "] ");
        return continuar(p, d);
    }
}

final class Autenticacion extends Middleware {
    @Override
    String procesar(Peticion p, Manejador d) {
        if (!"token-valido".equals(p.token())) {
            return "401 No autorizado";
        }
        return continuar(p, d);
    }
}

final class LimitePeticiones extends Middleware {
    private final int maximo;
    private final Map<String, Integer> conteo = new HashMap<>();

    LimitePeticiones(int maximo) {
        this.maximo = maximo;
    }

    @Override
    String procesar(Peticion p, Manejador d) {
        int n = conteo.merge(p.token(), 1, Integer::sum);
        return n > maximo ? "429 Demasiadas peticiones" : continuar(p, d);
    }
}
