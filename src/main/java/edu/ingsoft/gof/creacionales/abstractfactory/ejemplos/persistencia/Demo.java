package edu.ingsoft.gof.creacionales.abstractfactory.ejemplos.persistencia;

import java.util.ArrayList;
import java.util.List;

/** Abstract Factory para familias de persistencia que deben usarse juntas. */
public class Demo {
    public static void main(String[] args) {
        for (FabricaPersistencia f : List.of(new FabricaPostgres(), new FabricaMongo())) {
            Conexion cx = f.crearConexion("tienda");
            RepositorioClientes repo = f.crearRepositorio(cx);
            repo.guardar("Ana");
            repo.guardar("Luis");
            System.out.println(cx.descripcion() + " -> " + repo.listar());
        }
    }
}

interface Conexion {
    String descripcion();
}

interface RepositorioClientes {
    void guardar(String nombre);

    List<String> listar();
}

interface FabricaPersistencia {
    Conexion crearConexion(String baseDatos);

    RepositorioClientes crearRepositorio(Conexion conexion);
}

final class FabricaPostgres implements FabricaPersistencia {
    @Override
    public Conexion crearConexion(String bd) {
        return () -> "jdbc:postgresql://localhost/" + bd;
    }

    @Override
    public RepositorioClientes crearRepositorio(Conexion cx) {
        return new RepositorioClientes() {
            private final List<String> filas = new ArrayList<>();

            @Override
            public void guardar(String nombre) {
                filas.add("INSERT INTO clientes VALUES('" + nombre + "')");
            }

            @Override
            public List<String> listar() {
                return filas;
            }
        };
    }
}

final class FabricaMongo implements FabricaPersistencia {
    @Override
    public Conexion crearConexion(String bd) {
        return () -> "mongodb://localhost/" + bd;
    }

    @Override
    public RepositorioClientes crearRepositorio(Conexion cx) {
        return new RepositorioClientes() {
            private final List<String> docs = new ArrayList<>();

            @Override
            public void guardar(String nombre) {
                docs.add("{\"nombre\":\"" + nombre + "\"}");
            }

            @Override
            public List<String> listar() {
                return docs;
            }
        };
    }
}
