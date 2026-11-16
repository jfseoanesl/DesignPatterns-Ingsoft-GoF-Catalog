package edu.ingsoft.gof.creacionales.prototype.solucion;

public class Demo {
    public static void main(String[] args) {
        Grupo original = new Grupo();
        original.agregar(new Circulo(0, 0, 10));

        Grupo copia = (Grupo) new EditorDiagramas().duplicar(original);
        copia.agregar(new Rectangulo(5, 5, 30, 10));

        System.out.println("original = " + original);
        System.out.println("copia    = " + copia);

        RegistroFiguras paleta = new RegistroFiguras();
        paleta.registrar("nodo", new Circulo(0, 0, 25));
        paleta.registrar("nota", new Rectangulo(0, 0, 120, 60));
        System.out.println("de la paleta: " + paleta.crear("nodo") + ", "
                + paleta.crear("nota"));
    }
}
