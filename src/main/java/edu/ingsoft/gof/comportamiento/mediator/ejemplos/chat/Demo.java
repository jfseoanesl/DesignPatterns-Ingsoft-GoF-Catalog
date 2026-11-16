package edu.ingsoft.gof.comportamiento.mediator.ejemplos.chat;

import java.util.LinkedHashMap;
import java.util.Map;

/** La sala de chat es el mediador entre usuarios. */
public class Demo {
    public static void main(String[] args) {
        SalaChat sala = new SalaChat();
        Usuario ana = new Usuario("Ana", sala);
        Usuario luis = new Usuario("Luis", sala);
        Usuario sara = new Usuario("Sara", sala);
        ana.enviar("¡Hola a todos!");
        luis.enviar("@Sara ¿revisaste el diagrama?");
        sara.enviar("Sí, quedó listo");
    }
}

final class SalaChat {
    private final Map<String, Usuario> usuarios = new LinkedHashMap<>();

    void unir(Usuario u) {
        usuarios.put(u.nombre(), u);
    }

    void difundir(Usuario emisor, String texto) {
        if (texto.startsWith("@")) {
            String destino = texto.substring(1, texto.indexOf(' '));
            Usuario u = usuarios.get(destino);
            if (u != null) {
                u.recibir(emisor.nombre() + " (privado)", texto.substring(destino.length() + 2));
            }
            return;
        }
        usuarios.values().stream().filter(u -> u != emisor)
                .forEach(u -> u.recibir(emisor.nombre(), texto));
    }
}

final class Usuario {
    private final String nombre;
    private final SalaChat sala;

    Usuario(String nombre, SalaChat sala) {
        this.nombre = nombre;
        this.sala = sala;
        sala.unir(this);
    }

    String nombre() {
        return nombre;
    }

    void enviar(String texto) {
        sala.difundir(this, texto);
    }

    void recibir(String de, String texto) {
        System.out.println("  [" + nombre + "] " + de + ": " + texto);
    }
}
