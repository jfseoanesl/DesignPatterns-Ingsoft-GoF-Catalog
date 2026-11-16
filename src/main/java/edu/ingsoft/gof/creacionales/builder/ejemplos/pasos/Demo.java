package edu.ingsoft.gof.creacionales.builder.ejemplos.pasos;

/** Step Builder: el compilador impide omitir pasos obligatorios. */
public class Demo {
    public static void main(String[] args) {
        Correo c = Correo.nuevo()
                .para("cliente@correo.co")   // obligatorio
                .asunto("Pedido confirmado") // obligatorio
                .cuerpo("Su pedido #123 fue confirmado.")
                .copiaA("ventas@tienda.co")
                .build();
        System.out.println(c);
        // Correo.nuevo().asunto("x");  <- no compila: primero hay que llamar a para()
    }
}

record Correo(String para, String asunto, String cuerpo, String copia) {

    static PasoPara nuevo() {
        return new Pasos();
    }

    interface PasoPara {
        PasoAsunto para(String destinatario);
    }

    interface PasoAsunto {
        PasoOpcional asunto(String asunto);
    }

    interface PasoOpcional {
        PasoOpcional cuerpo(String cuerpo);

        PasoOpcional copiaA(String copia);

        Correo build();
    }

    private static final class Pasos implements PasoPara, PasoAsunto, PasoOpcional {
        private String para;
        private String asunto;
        private String cuerpo = "";
        private String copia;

        @Override
        public PasoAsunto para(String d) {
            this.para = d;
            return this;
        }

        @Override
        public PasoOpcional asunto(String a) {
            this.asunto = a;
            return this;
        }

        @Override
        public PasoOpcional cuerpo(String c) {
            this.cuerpo = c;
            return this;
        }

        @Override
        public PasoOpcional copiaA(String c) {
            this.copia = c;
            return this;
        }

        @Override
        public Correo build() {
            return new Correo(para, asunto, cuerpo, copia);
        }
    }
}
