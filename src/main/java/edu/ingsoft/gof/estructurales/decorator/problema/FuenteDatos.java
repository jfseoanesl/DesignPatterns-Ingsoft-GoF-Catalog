package edu.ingsoft.gof.estructurales.decorator.problema;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/** DEUDA TÉCNICA: banderas y condicionales para cada capacidad. */
public class FuenteDatos {
    private byte[] datos = new byte[0];
    private final boolean cifrar;
    private final boolean comprimir;

    public FuenteDatos(boolean cifrar, boolean comprimir) {
        this.cifrar = cifrar;
        this.comprimir = comprimir;
    }

    public void escribir(String texto) {
        byte[] b = texto.getBytes(StandardCharsets.UTF_8);
        if (comprimir) {
            b = comprimirBytes(b);
        }
        if (cifrar) {
            b = xor(b); // el orden está fijado aquí...
        }
        datos = b;
    }

    public String leer() {
        byte[] b = datos;
        if (cifrar) {
            b = xor(b); // ...y debe invertirse manualmente aquí
        }
        if (comprimir) {
            b = descomprimirBytes(b);
        }
        return new String(b, StandardCharsets.UTF_8);
    }

    public int tamanoAlmacenado() {
        return datos.length;
    }

    private byte[] xor(byte[] b) {
        byte[] r = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            r[i] = (byte) (b[i] ^ 0x5A);
        }
        return r;
    }

    private byte[] comprimirBytes(byte[] b) {
        Deflater d = new Deflater();
        d.setInput(b);
        d.finish();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[256];
        while (!d.finished()) {
            out.write(buf, 0, d.deflate(buf));
        }
        d.end();
        return out.toByteArray();
    }

    private byte[] descomprimirBytes(byte[] b) {
        try {
            Inflater inf = new Inflater();
            inf.setInput(b);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[256];
            while (!inf.finished()) {
                out.write(buf, 0, inf.inflate(buf));
            }
            inf.end();
            return out.toByteArray();
        } catch (DataFormatException e) {
            throw new IllegalStateException(e);
        }
    }
}
