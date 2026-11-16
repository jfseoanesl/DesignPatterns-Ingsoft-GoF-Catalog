package edu.ingsoft.gof.estructurales.bridge.solucion;

/** Implementor: primitivas de transporte. */
public interface CanalEnvio {
    String entregar(String destino, String contenido);
}
