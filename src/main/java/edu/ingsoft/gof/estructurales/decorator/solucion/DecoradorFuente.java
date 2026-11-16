package edu.ingsoft.gof.estructurales.decorator.solucion;

/** Decorator base: reenvía todas las operaciones. */
public abstract class DecoradorFuente implements FuenteDatos {
    protected final FuenteDatos envuelta;

    protected DecoradorFuente(FuenteDatos envuelta) {
        this.envuelta = envuelta;
    }

    @Override
    public void escribir(byte[] datos) {
        envuelta.escribir(datos);
    }

    @Override
    public byte[] leer() {
        return envuelta.leer();
    }
}
