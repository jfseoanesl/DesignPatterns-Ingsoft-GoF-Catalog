package edu.ingsoft.gof.comportamiento.observer.ejemplos.bus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/** Bus de eventos tipado (publicar/suscribir) con desuscripción AutoCloseable. */
public class Demo {
    public static void main(String[] args) throws Exception {
        BusEventos bus = new BusEventos();
        AutoCloseable inventario = bus.suscribir(PedidoCreado.class,
                e -> System.out.println("  Inventario reserva " + e.sku()));
        bus.suscribir(PedidoCreado.class, e -> System.out.println("  Correo a " + e.cliente()));
        bus.suscribir(PagoRechazado.class, e -> System.out.println("  Alerta: " + e.motivo()));
        bus.publicar(new PedidoCreado("ana", "SKU-1"));

        inventario.close();
        System.out.println("(inventario desuscrito)");
        bus.publicar(new PedidoCreado("luis", "SKU-2"));
        bus.publicar(new PagoRechazado("fondos insuficientes"));
    }
}

record PedidoCreado(String cliente, String sku) {
}

record PagoRechazado(String motivo) {
}

final class BusEventos {
    private final Map<Class<?>, List<Consumer<Object>>> suscriptores = new ConcurrentHashMap<>();

    <E> AutoCloseable suscribir(Class<E> tipo, Consumer<? super E> manejador) {
        Consumer<Object> envoltura = o -> manejador.accept(tipo.cast(o));
        suscriptores.computeIfAbsent(tipo, k -> new CopyOnWriteArrayList<>()).add(envoltura);
        return () -> suscriptores.get(tipo).remove(envoltura);
    }

    void publicar(Object evento) {
        suscriptores.getOrDefault(evento.getClass(), List.of()).forEach(m -> m.accept(evento));
    }
}
