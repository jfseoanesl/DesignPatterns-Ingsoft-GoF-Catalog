package edu.ingsoft.gof.estructurales.bridge.ejemplos.control;

/** Bridge clásico: controles (abstracción) × dispositivos (implementación). */
public class Demo {
    public static void main(String[] args) {
        ControlAvanzado control = new ControlAvanzado(new Televisor());
        control.encender();
        control.subirVolumen();
        control.silenciar();
        new Control(new Radio()).encender();
    }
}

interface Dispositivo {
    boolean encendido();

    void encendido(boolean valor);

    int volumen();

    void volumen(int valor);

    String nombre();
}

abstract class DispositivoBase implements Dispositivo {
    private boolean on;
    private int vol = 30;

    @Override
    public boolean encendido() {
        return on;
    }

    @Override
    public void encendido(boolean v) {
        on = v;
        System.out.println(nombre() + (v ? " encendido" : " apagado"));
    }

    @Override
    public int volumen() {
        return vol;
    }

    @Override
    public void volumen(int v) {
        vol = Math.max(0, Math.min(100, v));
        System.out.println(nombre() + " volumen=" + vol);
    }
}

final class Televisor extends DispositivoBase {
    @Override
    public String nombre() {
        return "TV";
    }
}

final class Radio extends DispositivoBase {
    @Override
    public String nombre() {
        return "Radio";
    }
}

class Control {
    protected final Dispositivo dispositivo;

    Control(Dispositivo d) {
        this.dispositivo = d;
    }

    void encender() {
        dispositivo.encendido(!dispositivo.encendido());
    }

    void subirVolumen() {
        dispositivo.volumen(dispositivo.volumen() + 10);
    }
}

class ControlAvanzado extends Control {
    ControlAvanzado(Dispositivo d) {
        super(d);
    }

    void silenciar() {
        dispositivo.volumen(0);
    }
}
