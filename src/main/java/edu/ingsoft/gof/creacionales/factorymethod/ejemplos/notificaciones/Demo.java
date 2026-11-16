package edu.ingsoft.gof.creacionales.factorymethod.ejemplos.notificaciones;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/** Factory Method parametrizado: un registro reemplaza el switch. */
public class Demo {
    public static void main(String[] args) {
        FabricaNotificaciones fabrica = new FabricaNotificaciones();
        fabrica.registrar("push", Push::new); // extensión sin modificar la fábrica
        for (String canal : new String[] {"email", "sms", "push"}) {
            System.out.println(fabrica.crear(canal).enviar("Su pedido va en camino"));
        }
        System.out.println("Canales disponibles: " + fabrica.canales());
    }
}

interface Notificacion {
    String enviar(String mensaje);
}

final class Email implements Notificacion {
    @Override
    public String enviar(String m) {
        return "[EMAIL] " + m;
    }
}

final class Sms implements Notificacion {
    @Override
    public String enviar(String m) {
        return "[SMS] " + (m.length() > 20 ? m.substring(0, 20) + "…" : m);
    }
}

final class Push implements Notificacion {
    @Override
    public String enviar(String m) {
        return "[PUSH] 🔔 " + m;
    }
}

final class FabricaNotificaciones {
    private final Map<String, Supplier<? extends Notificacion>> registro =
            new LinkedHashMap<>();

    FabricaNotificaciones() {
        registrar("email", Email::new);
        registrar("sms", Sms::new);
    }

    void registrar(String canal, Supplier<? extends Notificacion> creador) {
        registro.put(canal, creador);
    }

    Notificacion crear(String canal) {
        Supplier<? extends Notificacion> s = registro.get(canal);
        if (s == null) {
            throw new IllegalArgumentException("Canal no registrado: " + canal);
        }
        return s.get();
    }

    java.util.Set<String> canales() {
        return registro.keySet();
    }
}
