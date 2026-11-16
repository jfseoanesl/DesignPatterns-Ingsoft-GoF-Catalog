package edu.ingsoft.gof.creacionales.abstractfactory.solucion;

import java.util.function.Supplier;

/** Reemplaza el String libre: la familia se elige una sola vez. */
public enum Tema {
    CLARO(FabricaTemaClaro::new),
    OSCURO(FabricaTemaOscuro::new);

    private final Supplier<FabricaUI> proveedor;

    Tema(Supplier<FabricaUI> proveedor) {
        this.proveedor = proveedor;
    }

    public FabricaUI fabrica() {
        return proveedor.get();
    }
}
