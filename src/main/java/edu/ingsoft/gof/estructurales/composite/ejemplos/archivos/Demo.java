package edu.ingsoft.gof.estructurales.composite.ejemplos.archivos;

import java.util.ArrayList;
import java.util.List;

/** Composite sobre un sistema de archivos. */
public class Demo {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("proyecto");
        Carpeta src = new Carpeta("src");
        src.agregar(new Archivo("App.java", 1200));
        src.agregar(new Archivo("Util.java", 800));
        raiz.agregar(src);
        raiz.agregar(new Archivo("README.md", 300));
        raiz.agregar(new Archivo("logo.png", 25_000));

        System.out.println("Tamaño total: " + raiz.tamano() + " bytes");
        System.out.println("Archivos .java: " + raiz.buscar(".java"));
    }
}

interface Nodo {
    String nombre();

    long tamano();

    List<String> buscar(String extension);
}

record Archivo(String nombre, long tamano) implements Nodo {
    @Override
    public List<String> buscar(String ext) {
        return nombre.endsWith(ext) ? List.of(nombre) : List.of();
    }
}

final class Carpeta implements Nodo {
    private final String nombre;
    private final List<Nodo> hijos = new ArrayList<>();

    Carpeta(String nombre) {
        this.nombre = nombre;
    }

    void agregar(Nodo n) {
        hijos.add(n);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public long tamano() {
        return hijos.stream().mapToLong(Nodo::tamano).sum();
    }

    @Override
    public List<String> buscar(String ext) {
        List<String> r = new ArrayList<>();
        hijos.forEach(h -> h.buscar(ext).forEach(n -> r.add(nombre + "/" + n)));
        return r;
    }
}
