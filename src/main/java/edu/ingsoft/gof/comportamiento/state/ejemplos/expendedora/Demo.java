package edu.ingsoft.gof.comportamiento.state.ejemplos.expendedora;

/** Máquina expendedora: el estado decide qué hacer con cada acción. */
public class Demo {
    public static void main(String[] args) {
        Expendedora m = new Expendedora(1);
        m.girarManija();
        m.insertarMoneda();
        m.insertarMoneda();
        m.girarManija();
        m.insertarMoneda();
    }
}

interface Estado {
    void insertarMoneda(Expendedora m);

    void girarManija(Expendedora m);
}

final class SinMoneda implements Estado {
    @Override
    public void insertarMoneda(Expendedora m) {
        System.out.println("Moneda aceptada");
        m.estado(new ConMoneda());
    }

    @Override
    public void girarManija(Expendedora m) {
        System.out.println("Inserte una moneda primero");
    }
}

final class ConMoneda implements Estado {
    @Override
    public void insertarMoneda(Expendedora m) {
        System.out.println("Ya hay una moneda; se devuelve la nueva");
    }

    @Override
    public void girarManija(Expendedora m) {
        m.dispensar();
        m.estado(m.unidades() > 0 ? new SinMoneda() : new Agotada());
    }
}

final class Agotada implements Estado {
    @Override
    public void insertarMoneda(Expendedora m) {
        System.out.println("Máquina agotada: moneda devuelta");
    }

    @Override
    public void girarManija(Expendedora m) {
        System.out.println("Máquina agotada");
    }
}

final class Expendedora {
    private Estado estado;
    private int unidades;

    Expendedora(int unidades) {
        this.unidades = unidades;
        this.estado = unidades > 0 ? new SinMoneda() : new Agotada();
    }

    void insertarMoneda() {
        estado.insertarMoneda(this);
    }

    void girarManija() {
        estado.girarManija(this);
    }

    void estado(Estado e) {
        estado = e;
    }

    int unidades() {
        return unidades;
    }

    void dispensar() {
        unidades--;
        System.out.println("Dispensando producto (quedan " + unidades + ")");
    }
}
