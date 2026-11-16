package edu.ingsoft.gof.creacionales.singleton.problema;

/** DEUDA TÉCNICA: cualquiera puede crearla y modificarla. */
public class Configuracion {
    public static int cargas = 0;
    public String urlBaseDatos;
    public int maxConexiones;

    public Configuracion() {
        // Simula la lectura costosa de app.properties
        cargas++;
        urlBaseDatos = "jdbc:postgresql://db:5432/tienda";
        maxConexiones = 10;
    }
}
