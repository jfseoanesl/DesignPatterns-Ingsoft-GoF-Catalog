package edu.ingsoft.gof.estructurales.composite.ejemplos.menu;

import java.util.ArrayList;
import java.util.List;

/** Menús y submenús tratados uniformemente. */
public class Demo {
    public static void main(String[] args) {
        Menu carta = new Menu("Carta");
        Menu entradas = new Menu("Entradas");
        entradas.agregar(new Plato("Patacones", 12_000, true));
        entradas.agregar(new Plato("Empanadas de carne", 9_000, false));
        Menu fuertes = new Menu("Platos fuertes");
        fuertes.agregar(new Plato("Bandeja paisa", 38_000, false));
        fuertes.agregar(new Plato("Ajiaco vegetariano", 30_000, true));
        carta.agregar(entradas);
        carta.agregar(fuertes);

        carta.imprimir("");
        System.out.println("Vegetarianos: " + carta.vegetarianos());
    }
}

abstract class ComponenteMenu {
    abstract void imprimir(String sangria);

    abstract List<String> vegetarianos();
}

final class Plato extends ComponenteMenu {
    private final String nombre;
    private final int precio;
    private final boolean vegetariano;

    Plato(String n, int p, boolean v) {
        nombre = n;
        precio = p;
        vegetariano = v;
    }

    @Override
    void imprimir(String s) {
        System.out.printf("%s- %s $%,d%s%n", s, nombre, precio, vegetariano ? " (V)" : "");
    }

    @Override
    List<String> vegetarianos() {
        return vegetariano ? List.of(nombre) : List.of();
    }
}

final class Menu extends ComponenteMenu {
    private final String titulo;
    private final List<ComponenteMenu> items = new ArrayList<>();

    Menu(String t) {
        titulo = t;
    }

    void agregar(ComponenteMenu c) {
        items.add(c);
    }

    @Override
    void imprimir(String s) {
        System.out.println(s + titulo.toUpperCase());
        items.forEach(i -> i.imprimir(s + "  "));
    }

    @Override
    List<String> vegetarianos() {
        List<String> r = new ArrayList<>();
        items.forEach(i -> r.addAll(i.vegetarianos()));
        return r;
    }
}
