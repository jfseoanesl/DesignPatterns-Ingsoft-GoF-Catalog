package edu.ingsoft.gof.estructurales.decorator.problema;

public class Demo {
    public static void main(String[] args) {
        String texto = "cliente=Ana;tarjeta=4111-xxxx;".repeat(10);
        FuenteDatos f = new FuenteDatos(true, true);
        f.escribir(texto);
        System.out.println("Bytes originales: " + texto.length()
                + " | almacenados: " + f.tamanoAlmacenado());
        System.out.println("Lectura correcta: " + f.leer().equals(texto));
        System.out.println("¿Auditoría? Requiere otra bandera y modificar la clase.");
    }
}
