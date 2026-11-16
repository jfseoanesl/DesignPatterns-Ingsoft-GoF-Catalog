package edu.ingsoft.gof.comportamiento.command.problema;

public class Demo {
    public static void main(String[] args) {
        Documento doc = new Documento();
        BarraHerramientas barra = new BarraHerramientas(doc);
        AtajosTeclado atajos = new AtajosTeclado(doc);
        barra.clic("escribir", "Hola ");
        atajos.presionar("Ctrl+V", "mundo");
        barra.clic("mayus", null);
        System.out.println(doc.contenido());
        System.out.println("¿Deshacer las mayúsculas? No hay forma.");
    }
}
