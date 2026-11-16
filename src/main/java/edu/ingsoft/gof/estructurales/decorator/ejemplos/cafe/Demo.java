package edu.ingsoft.gof.estructurales.decorator.ejemplos.cafe;

/** Decorator clásico: bebidas y complementos. */
public class Demo {
    public static void main(String[] args) {
        Bebida pedido = new Crema(new Caramelo(new Leche(new CafeAmericano())));
        System.out.printf("%s -> $%,d%n", pedido.descripcion(), pedido.precio());
        Bebida doble = new Leche(new Leche(new CafeAmericano()));
        System.out.printf("%s -> $%,d%n", doble.descripcion(), doble.precio());
    }
}

interface Bebida {
    String descripcion();

    int precio();
}

final class CafeAmericano implements Bebida {
    @Override
    public String descripcion() {
        return "Americano";
    }

    @Override
    public int precio() {
        return 5_000;
    }
}

abstract class Complemento implements Bebida {
    protected final Bebida bebida;

    Complemento(Bebida b) {
        this.bebida = b;
    }
}

final class Leche extends Complemento {
    Leche(Bebida b) {
        super(b);
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + " + leche";
    }

    @Override
    public int precio() {
        return bebida.precio() + 1_500;
    }
}

final class Caramelo extends Complemento {
    Caramelo(Bebida b) {
        super(b);
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + " + caramelo";
    }

    @Override
    public int precio() {
        return bebida.precio() + 2_000;
    }
}

final class Crema extends Complemento {
    Crema(Bebida b) {
        super(b);
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + " + crema";
    }

    @Override
    public int precio() {
        return bebida.precio() + 2_500;
    }
}
