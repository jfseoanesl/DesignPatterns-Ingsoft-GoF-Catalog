package edu.ingsoft.gof.estructurales.proxy.ejemplos.virtual;

import java.util.List;

/** Proxy virtual: la imagen se carga solo cuando se muestra. */
public class Demo {
    public static void main(String[] args) {
        List<Imagen> galeria = List.of(new ProxyImagen("foto1.jpg"),
                new ProxyImagen("foto2.jpg"), new ProxyImagen("foto3.jpg"));
        System.out.println("Galería creada con " + galeria.size()
                + " imágenes (ninguna cargada)");
        System.out.println(galeria.get(1).mostrar());
        System.out.println(galeria.get(1).mostrar());
    }
}

interface Imagen {
    String mostrar();
}

final class ImagenAltaResolucion implements Imagen {
    private final String archivo;

    ImagenAltaResolucion(String archivo) {
        this.archivo = archivo;
        System.out.println("  cargando " + archivo + " desde disco (lento)...");
    }

    @Override
    public String mostrar() {
        return "Mostrando " + archivo;
    }
}

final class ProxyImagen implements Imagen {
    private final String archivo;
    private ImagenAltaResolucion real;

    ProxyImagen(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public String mostrar() {
        if (real == null) {
            real = new ImagenAltaResolucion(archivo);
        }
        return real.mostrar();
    }
}
