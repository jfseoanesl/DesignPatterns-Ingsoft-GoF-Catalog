package edu.ingsoft.gof.estructurales.decorator.solucion;

import java.nio.charset.StandardCharsets;

public class Demo {
    public static void main(String[] args) {
        String texto = "cliente=Ana;tarjeta=4111-xxxx;".repeat(10);
        FuenteMemoria memoria = new FuenteMemoria();

        // auditoría -> compresión -> cifrado -> memoria (orden elegido por el cliente)
        DecoradorAuditoria auditada = new DecoradorAuditoria(
                new DecoradorCompresion(new DecoradorCifrado(memoria, (byte) 0x5A)));

        auditada.escribir(texto.getBytes(StandardCharsets.UTF_8));
        String leido = new String(auditada.leer(), StandardCharsets.UTF_8);

        System.out.println("Bytes originales: " + texto.length()
                + " | almacenados: " + memoria.tamano());
        System.out.println("Lectura correcta: " + leido.equals(texto));
        System.out.println("Bitácora: " + auditada.bitacora());
    }
}
