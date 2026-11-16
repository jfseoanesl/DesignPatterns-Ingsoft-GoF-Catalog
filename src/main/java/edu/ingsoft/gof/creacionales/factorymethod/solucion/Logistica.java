package edu.ingsoft.gof.creacionales.factorymethod.solucion;

/** Creator: algoritmo estable + método fábrica abstracto. */
public abstract class Logistica {

    public final String planificarEntrega(double km) {
        Transporte t = crearTransporte(); // <- Factory Method
        double costo = t.costoPorKm() * km;
        return t.nombre() + ": " + t.despachar()
                + " | costo $" + String.format("%,.0f", costo);
    }

    protected abstract Transporte crearTransporte();
}
