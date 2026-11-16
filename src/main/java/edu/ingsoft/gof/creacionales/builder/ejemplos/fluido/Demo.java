package edu.ingsoft.gof.creacionales.builder.ejemplos.fluido;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Builder fluido (Effective Java, ítem 2): reemplaza constructores telescópicos. */
public class Demo {
    public static void main(String[] args) {
        SolicitudHttp get = SolicitudHttp.para("https://api.tienda.co/productos").build();
        SolicitudHttp post = SolicitudHttp.para("https://api.tienda.co/pedidos")
                .metodo("POST")
                .encabezado("Content-Type", "application/json")
                .cuerpo("{\"producto\":42}")
                .tiempoEspera(Duration.ofSeconds(5))
                .build();
        System.out.println(get);
        System.out.println(post);
        try {
            SolicitudHttp.para("https://x.co").metodo("GET").cuerpo("{}").build();
        } catch (IllegalStateException e) {
            System.out.println("Validación en build(): " + e.getMessage());
        }
    }
}

final class SolicitudHttp {
    private final String url;
    private final String metodo;
    private final Map<String, String> encabezados;
    private final String cuerpo;
    private final Duration tiempoEspera;

    private SolicitudHttp(Builder b) {
        this.url = b.url;
        this.metodo = b.metodo;
        this.encabezados = Map.copyOf(b.encabezados); // copia defensiva inmutable
        this.cuerpo = b.cuerpo;
        this.tiempoEspera = b.tiempoEspera;
    }

    static Builder para(String url) {
        return new Builder(url);
    }

    @Override
    public String toString() {
        return metodo + " " + url + " " + encabezados
                + (cuerpo == null ? "" : " cuerpo=" + cuerpo)
                + " timeout=" + tiempoEspera.toSeconds() + "s";
    }

    static final class Builder {
        private final String url;
        private String metodo = "GET";
        private final Map<String, String> encabezados = new LinkedHashMap<>();
        private String cuerpo;
        private Duration tiempoEspera = Duration.ofSeconds(30);

        private Builder(String url) {
            this.url = Objects.requireNonNull(url, "url");
        }

        Builder metodo(String m) {
            this.metodo = m;
            return this;
        }

        Builder encabezado(String k, String v) {
            encabezados.put(k, v);
            return this;
        }

        Builder cuerpo(String c) {
            this.cuerpo = c;
            return this;
        }

        Builder tiempoEspera(Duration d) {
            this.tiempoEspera = d;
            return this;
        }

        SolicitudHttp build() {
            if (cuerpo != null && metodo.equals("GET")) {
                throw new IllegalStateException("una solicitud GET no admite cuerpo");
            }
            return new SolicitudHttp(this);
        }
    }
}
