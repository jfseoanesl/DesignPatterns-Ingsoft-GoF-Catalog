package edu.ingsoft.gof.estructurales.proxy.ejemplos.dinamico;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/** Proxy dinámico del JDK: sirve para cualquier interfaz. */
public class Demo {
    public static void main(String[] args) {
        RepositorioProductos repo = conRegistro(new RepositorioEnMemoria(),
                RepositorioProductos.class);
        repo.guardar("P1", "Teclado");
        System.out.println("Resultado: " + repo.buscar("P1"));
    }

    static <T> T conRegistro(T destino, Class<T> interfaz) {
        InvocationHandler h = (proxy, metodo, argumentos) -> {
            long t0 = System.nanoTime();
            try {
                return metodo.invoke(destino, argumentos);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            } finally {
                System.out.printf("  [proxy] %s.%s tardó %s%n", interfaz.getSimpleName(),
                        metodo.getName(), (System.nanoTime() - t0) >= 0 ? "<1 ms" : "?");
            }
        };
        Object p = Proxy.newProxyInstance(interfaz.getClassLoader(),
                new Class<?>[] {interfaz}, h);
        return interfaz.cast(p);
    }
}

interface RepositorioProductos {
    void guardar(String id, String nombre);

    String buscar(String id);
}

final class RepositorioEnMemoria implements RepositorioProductos {
    private final Map<String, String> datos = new HashMap<>();

    @Override
    public void guardar(String id, String nombre) {
        datos.put(id, nombre);
    }

    @Override
    public String buscar(String id) {
        return datos.get(id);
    }
}
