package edu.ingsoft.gof.creacionales.prototype.ejemplos.plantillas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Registro de plantillas: se clonan y personalizan sin alterar el prototipo. */
public class Demo {
    public static void main(String[] args) {
        RegistroPlantillas registro = new RegistroPlantillas();
        Contrato base = new Contrato("Prestación de servicios");
        base.agregarClausula("Confidencialidad");
        base.agregarClausula("Propiedad intelectual");
        registro.registrar("servicios", base);

        Contrato paraAna = registro.obtener("servicios");
        paraAna.setCliente("Ana Pérez");
        paraAna.agregarClausula("Trabajo remoto");

        Contrato paraLuis = registro.obtener("servicios");
        paraLuis.setCliente("Luis Gómez");

        System.out.println(paraAna);
        System.out.println(paraLuis);
        System.out.println("Plantilla intacta: " + registro.obtener("servicios"));
    }
}

final class Contrato {
    private final String tipo;
    private String cliente = "<por definir>";
    private final List<String> clausulas;

    Contrato(String tipo) {
        this.tipo = tipo;
        this.clausulas = new ArrayList<>();
    }

    private Contrato(Contrato otro) {
        this.tipo = otro.tipo;
        this.cliente = otro.cliente;
        this.clausulas = new ArrayList<>(otro.clausulas); // copia profunda de la lista
    }

    Contrato copiar() {
        return new Contrato(this);
    }

    void setCliente(String c) {
        this.cliente = c;
    }

    void agregarClausula(String c) {
        clausulas.add(c);
    }

    @Override
    public String toString() {
        return tipo + " para " + cliente + " " + clausulas;
    }
}

final class RegistroPlantillas {
    private final Map<String, Contrato> plantillas = new HashMap<>();

    void registrar(String clave, Contrato c) {
        plantillas.put(clave, c);
    }

    Contrato obtener(String clave) {
        return plantillas.get(clave).copiar();
    }
}
