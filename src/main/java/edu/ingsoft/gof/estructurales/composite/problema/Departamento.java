package edu.ingsoft.gof.estructurales.composite.problema;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    public String nombre;
    public List<Object> miembros = new ArrayList<>(); // empleados o departamentos

    public Departamento(String nombre) {
        this.nombre = nombre;
    }
}
