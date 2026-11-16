package edu.ingsoft.gof.comportamiento.iterator.ejemplos.arbol;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Iterador inorden de un árbol binario de búsqueda con pila explícita. */
public class Demo {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        for (int v : new int[] {50, 30, 70, 20, 40, 60, 80}) {
            arbol.insertar(v);
        }
        StringBuilder sb = new StringBuilder();
        for (int v : arbol) {
            sb.append(v).append(' ');
        }
        System.out.println("Inorden: " + sb.toString().trim());
    }
}

final class ArbolBinario<T extends Comparable<T>> implements Iterable<T> {
    private final class Nodo {
        final T valor;
        Nodo izq;
        Nodo der;

        Nodo(T v) {
            valor = v;
        }
    }

    private Nodo raiz;

    void insertar(T v) {
        raiz = insertar(raiz, v);
    }

    private Nodo insertar(Nodo n, T v) {
        if (n == null) {
            return new Nodo(v);
        }
        if (v.compareTo(n.valor) < 0) {
            n.izq = insertar(n.izq, v);
        } else {
            n.der = insertar(n.der, v);
        }
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final Deque<Nodo> pila = new ArrayDeque<>();

            {
                apilarIzquierda(raiz);
            }

            private void apilarIzquierda(Nodo n) {
                for (; n != null; n = n.izq) {
                    pila.push(n);
                }
            }

            @Override
            public boolean hasNext() {
                return !pila.isEmpty();
            }

            @Override
            public T next() {
                if (pila.isEmpty()) {
                    throw new NoSuchElementException();
                }
                Nodo n = pila.pop();
                apilarIzquierda(n.der);
                return n.valor;
            }
        };
    }
}
