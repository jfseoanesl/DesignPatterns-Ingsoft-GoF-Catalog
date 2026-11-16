package edu.ingsoft.gof.comportamiento.iterator.ejemplos.failfast;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Colección propia con iterador fail-fast basado en un contador de modificaciones. */
public class Demo {
    public static void main(String[] args) {
        Bolsa<String> bolsa = new Bolsa<>();
        bolsa.agregar("a");
        bolsa.agregar("b");
        bolsa.agregar("c");
        try {
            for (String s : bolsa) {
                System.out.println("leído " + s);
                if (s.equals("b")) {
                    bolsa.agregar("d"); // modificación durante la iteración
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }
    }
}

final class Bolsa<T> implements Iterable<T> {
    private Object[] datos = new Object[2];
    private int tamano;
    private int modCount;

    void agregar(T v) {
        if (tamano == datos.length) {
            datos = Arrays.copyOf(datos, tamano * 2);
        }
        datos[tamano++] = v;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int esperado = modCount;
            private int pos;

            @Override
            public boolean hasNext() {
                return pos < tamano;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (modCount != esperado) {
                    throw new ConcurrentModificationException("la bolsa cambió");
                }
                if (pos >= tamano) {
                    throw new NoSuchElementException();
                }
                return (T) datos[pos++];
            }
        };
    }
}
