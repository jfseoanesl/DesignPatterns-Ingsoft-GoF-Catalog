package edu.ingsoft.gof.comportamiento.mediator.solucion;

public class Demo {
    public static void main(String[] args) {
        DialogoRegistro d = new DialogoRegistro();
        d.correo().escribir("ventas@empresa.co");
        System.out.println("Persona natural -> botón: " + d.registrar().habilitado());
        d.casilla().marcar(true);
        System.out.println("Empresa sin NIT -> botón: " + d.registrar().habilitado()
                + " | NIT habilitado: " + d.nit().habilitado());
        d.nit().escribir("900123456");
        System.out.println("Empresa con NIT -> botón: " + d.registrar().habilitado());
    }
}
