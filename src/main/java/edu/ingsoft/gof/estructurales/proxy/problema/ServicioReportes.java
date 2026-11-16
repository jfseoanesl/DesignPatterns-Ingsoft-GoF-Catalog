package edu.ingsoft.gof.estructurales.proxy.problema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** DEUDA TÉCNICA: negocio + seguridad + caché + bitácora en un solo lugar. */
public class ServicioReportes {
    private final Map<String, String> cache = new HashMap<>();
    private final List<String> bitacora = new ArrayList<>();
    private final ConexionCostosa conexion = new ConexionCostosa(); // ansiosa
    private int consultasReales;

    public String consolidado(Usuario usuario, String periodo) {
        bitacora.add(usuario.nombre() + " pidió " + periodo);
        if (!usuario.rol().equals("GERENTE")) {
            throw new SecurityException("Acceso denegado a " + usuario.nombre());
        }
        if (cache.containsKey(periodo)) {
            return cache.get(periodo);
        }
        consultasReales++;
        String r = conexion.consultar(periodo); // la verdadera lógica de negocio
        cache.put(periodo, r);
        return r;
    }

    public int consultasReales() {
        return consultasReales;
    }
}
