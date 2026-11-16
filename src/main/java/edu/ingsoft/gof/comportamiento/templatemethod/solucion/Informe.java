package edu.ingsoft.gof.comportamiento.templatemethod.solucion;

public record Informe(String formato, int validos, int rechazados) {
    @Override
    public String toString() {
        return formato + ": " + validos + " válidos, " + rechazados + " rechazados";
    }
}
