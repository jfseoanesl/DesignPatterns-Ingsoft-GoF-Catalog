package edu.ingsoft.gof.estructurales.decorator.solucion;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DecoradorCompresion extends DecoradorFuente {
    public DecoradorCompresion(FuenteDatos f) {
        super(f);
    }

    @Override
    public void escribir(byte[] datos) {
        Deflater d = new Deflater(Deflater.BEST_COMPRESSION);
        d.setInput(datos);
        d.finish();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[256];
        while (!d.finished()) {
            out.write(buf, 0, d.deflate(buf));
        }
        d.end();
        super.escribir(out.toByteArray());
    }

    @Override
    public byte[] leer() {
        try {
            Inflater inf = new Inflater();
            inf.setInput(super.leer());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[256];
            while (!inf.finished()) {
                out.write(buf, 0, inf.inflate(buf));
            }
            inf.end();
            return out.toByteArray();
        } catch (DataFormatException e) {
            throw new IllegalStateException("Datos corruptos", e);
        }
    }
}
