package edu.ingsoft.gof.creacionales.prototype.problema;

public class Demo {
    public static void main(String[] args) {
        Circulo c = new Circulo();
        c.radio = 10;
        Grupo original = new Grupo();
        original.hijos.add(c);

        EditorDiagramas editor = new EditorDiagramas();
        Grupo copia = (Grupo) editor.duplicar(original);
        copia.hijos.add(new Rectangulo()); // modifica también el original

        System.out.println("original = " + original);
        System.out.println("copia    = " + copia);
    }
}
