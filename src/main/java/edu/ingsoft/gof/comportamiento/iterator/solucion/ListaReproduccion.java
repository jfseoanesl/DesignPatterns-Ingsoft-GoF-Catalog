package edu.ingsoft.gof.comportamiento.iterator.solucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;

/** ConcreteAggregate: la representación es privada y puede cambiar. */
public class ListaReproduccion implements Iterable<Cancion> {
    private final List<Cancion> canciones = new ArrayList<>();

    public void agregar(Cancion c) {
        canciones.add(c);
    }

    @Override
    public Iterator<Cancion> iterator() {
        return new IteradorSecuencial();
    }

    public Iterable<Cancion> aleatorio(long semilla) {
        return () -> new IteradorAleatorio(semilla);
    }

    public Iterable<Cancion> favoritas() {
        return IteradorFavoritas::new;
    }

    private final class IteradorSecuencial implements Iterator<Cancion> {
        private int pos;

        @Override
        public boolean hasNext() {
            return pos < canciones.size();
        }

        @Override
        public Cancion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return canciones.get(pos++);
        }
    }

    /** Permutación sin repeticiones (Fisher–Yates vía Collections.shuffle). */
    private final class IteradorAleatorio implements Iterator<Cancion> {
        private final int[] orden;
        private int pos;

        IteradorAleatorio(long semilla) {
            List<Integer> idx = new ArrayList<>(IntStream.range(0, canciones.size())
                    .boxed().toList());
            Collections.shuffle(idx, new Random(semilla));
            orden = idx.stream().mapToInt(Integer::intValue).toArray();
        }

        @Override
        public boolean hasNext() {
            return pos < orden.length;
        }

        @Override
        public Cancion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return canciones.get(orden[pos++]);
        }
    }

    private final class IteradorFavoritas implements Iterator<Cancion> {
        private int pos;

        IteradorFavoritas() {
            avanzar();
        }

        private void avanzar() {
            while (pos < canciones.size() && !canciones.get(pos).favorita()) {
                pos++;
            }
        }

        @Override
        public boolean hasNext() {
            return pos < canciones.size();
        }

        @Override
        public Cancion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Cancion c = canciones.get(pos++);
            avanzar();
            return c;
        }
    }
}
