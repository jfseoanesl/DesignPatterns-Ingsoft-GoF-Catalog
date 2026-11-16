package edu.ingsoft.gof.estructurales.decorator.solucion;

/** ConcreteComponent: solo almacena. */
public class FuenteMemoria implements FuenteDatos {
    private byte[] contenido = new byte[0];

    @Override
    public void escribir(byte[] datos) {
        contenido = datos.clone();
    }

    @Override
    public byte[] leer() {
        return contenido.clone();
    }

    public int tamano() {
        return contenido.length;
    }
}
