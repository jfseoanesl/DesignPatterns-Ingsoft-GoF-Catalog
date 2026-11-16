package edu.ingsoft.gof.estructurales.decorator.solucion;

import java.util.ArrayList;
import java.util.List;

/** Nueva capacidad añadida sin modificar ninguna clase existente. */
public class DecoradorAuditoria extends DecoradorFuente {
    private final List<String> bitacora = new ArrayList<>();

    public DecoradorAuditoria(FuenteDatos f) {
        super(f);
    }

    @Override
    public void escribir(byte[] datos) {
        bitacora.add("escritura de " + datos.length + " bytes");
        super.escribir(datos);
    }

    @Override
    public byte[] leer() {
        byte[] r = super.leer();
        bitacora.add("lectura de " + r.length + " bytes");
        return r;
    }

    public List<String> bitacora() {
        return List.copyOf(bitacora);
    }
}
