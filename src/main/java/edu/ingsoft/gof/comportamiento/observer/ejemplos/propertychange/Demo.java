package edu.ingsoft.gof.comportamiento.observer.ejemplos.propertychange;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** Observer con el soporte estándar de JavaBeans. */
public class Demo {
    public static void main(String[] args) {
        Producto p = new Producto("Monitor 27\"", 890_000);
        PropertyChangeListener auditoria = e -> System.out.printf(
                "  [auditoría] %s: %s -> %s%n", e.getPropertyName(), e.getOldValue(),
                e.getNewValue());
        p.agregarEscucha(auditoria);
        p.agregarEscucha(e -> {
            if ((long) e.getNewValue() < (long) e.getOldValue()) {
                System.out.println("  [marketing] ¡Bajó de precio! Avisar a interesados");
            }
        });
        p.setPrecio(850_000);
        p.setPrecio(850_000); // sin cambio real: no notifica
        p.setPrecio(900_000);
    }
}

final class Producto {
    private final PropertyChangeSupport soporte = new PropertyChangeSupport(this);
    private final String nombre;
    private long precio;

    Producto(String nombre, long precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    void agregarEscucha(PropertyChangeListener l) {
        soporte.addPropertyChangeListener(l);
    }

    void setPrecio(long nuevo) {
        long anterior = precio;
        precio = nuevo;
        soporte.firePropertyChange("precio de " + nombre, anterior, nuevo);
    }
}
