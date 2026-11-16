package edu.ingsoft.gof.creacionales.prototype.problema;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    public List<Object> hijos = new ArrayList<>();

    @Override
    public String toString() {
        return "Grupo" + hijos;
    }
}
