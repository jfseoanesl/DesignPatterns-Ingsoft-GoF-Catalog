package edu.ingsoft.gof.estructurales.decorator.solucion;

/** Cifrado XOR didáctico (en producción: javax.crypto con AES-GCM). */
public class DecoradorCifrado extends DecoradorFuente {
    private final byte clave;

    public DecoradorCifrado(FuenteDatos f, byte clave) {
        super(f);
        this.clave = clave;
    }

    @Override
    public void escribir(byte[] datos) {
        super.escribir(xor(datos));
    }

    @Override
    public byte[] leer() {
        return xor(super.leer());
    }

    private byte[] xor(byte[] b) {
        byte[] r = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            r[i] = (byte) (b[i] ^ clave);
        }
        return r;
    }
}
