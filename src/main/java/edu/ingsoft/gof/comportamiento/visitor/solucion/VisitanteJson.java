package edu.ingsoft.gof.comportamiento.visitor.solucion;

public class VisitanteJson implements Visitante<String> {
    @Override
    public String visitar(Libro l) {
        return json("libro", l);
    }

    @Override
    public String visitar(Electronico e) {
        return json("electronico", e);
    }

    @Override
    public String visitar(Alimento a) {
        return json("alimento", a);
    }

    private String json(String tipo, Articulo a) {
        return "{\"tipo\":\"" + tipo + "\",\"nombre\":\"" + a.nombre() + "\"}";
    }
}
