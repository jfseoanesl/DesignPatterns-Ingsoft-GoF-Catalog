package edu.ingsoft.gof.creacionales.abstractfactory.ejemplos.nube;

/** Abstract Factory: servicios de un mismo proveedor de nube. */
public class Demo {
    public static void main(String[] args) {
        String proveedor = args.length > 0 ? args[0] : "aws";
        FabricaNube nube = proveedor.equals("azure") ? new FabricaAzure() : new FabricaAws();
        new ServicioFacturas(nube).emitir("FAC-001");
        new ServicioFacturas(new FabricaAzure()).emitir("FAC-002");
    }
}

interface Almacenamiento {
    String subir(String archivo);
}

interface ColaMensajes {
    void publicar(String mensaje);
}

interface FabricaNube {
    Almacenamiento crearAlmacenamiento();

    ColaMensajes crearCola();
}

final class FabricaAws implements FabricaNube {
    @Override
    public Almacenamiento crearAlmacenamiento() {
        return archivo -> "s3://facturas/" + archivo;
    }

    @Override
    public ColaMensajes crearCola() {
        return msg -> System.out.println("  SQS <- " + msg);
    }
}

final class FabricaAzure implements FabricaNube {
    @Override
    public Almacenamiento crearAlmacenamiento() {
        return archivo -> "https://cuenta.blob.core.windows.net/facturas/" + archivo;
    }

    @Override
    public ColaMensajes crearCola() {
        return msg -> System.out.println("  ServiceBus <- " + msg);
    }
}

/** Cliente: no sabe qué proveedor usa. */
final class ServicioFacturas {
    private final Almacenamiento almacenamiento;
    private final ColaMensajes cola;

    ServicioFacturas(FabricaNube nube) {
        this.almacenamiento = nube.crearAlmacenamiento();
        this.cola = nube.crearCola();
    }

    void emitir(String id) {
        String url = almacenamiento.subir(id + ".pdf");
        cola.publicar("factura-emitida " + url);
    }
}
