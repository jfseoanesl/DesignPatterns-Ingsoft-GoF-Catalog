package edu.ingsoft.gof.comportamiento.mediator.problema;

public class Demo {
    public static void main(String[] args) {
        CasillaEmpresa casilla = new CasillaEmpresa();
        CampoNit nit = new CampoNit();
        CampoCorreo correo = new CampoCorreo();
        BotonRegistrar boton = new BotonRegistrar();
        // cableado manual de la malla: 9 referencias
        casilla.nit = nit;
        casilla.correo = correo;
        casilla.boton = boton;
        nit.casilla = casilla;
        nit.correo = correo;
        nit.boton = boton;
        correo.casilla = casilla;
        correo.nit = nit;
        correo.boton = boton;

        correo.escribir("ventas@empresa.co");
        System.out.println("Persona natural -> botón: " + boton.habilitado);
        casilla.marcar(true);
        System.out.println("Empresa sin NIT -> botón: " + boton.habilitado);
        nit.escribir("900123456");
        System.out.println("Empresa con NIT -> botón: " + boton.habilitado);
    }
}
