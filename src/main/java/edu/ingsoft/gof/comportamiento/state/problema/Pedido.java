package edu.ingsoft.gof.comportamiento.state.problema;

/** DEUDA TÉCNICA: máquina de estados implícita con String y switches. */
public class Pedido {
    private String estado = "pendiente";

    public void pagar() {
        switch (estado) {
            case "pendiente" -> estado = "pagado";
            case "pagado", "enviado", "entregado" -> System.out.println("  Ya estaba pagado");
            case "cancelado" -> System.out.println("  No se puede pagar un pedido cancelado");
            default -> throw new IllegalStateException(estado);
        }
    }

    public void enviar() {
        switch (estado) {
            case "pagado" -> estado = "enviado";
            case "pendiente" -> System.out.println("  Debe pagarse antes de enviar");
            default -> System.out.println("  No se puede enviar en estado " + estado);
        }
    }

    public void entregar() {
        if (estado.equals("enviado")) {
            estado = "entregado";
        } else {
            System.out.println("  No se puede entregar en estado " + estado);
        }
    }

    public void cancelar() {
        switch (estado) {
            case "pendiente" -> estado = "cancelado";
            case "pagado" -> {
                System.out.println("  Reembolsando pago...");
                estado = "cancelado";
            }
            default -> System.out.println("  No se puede cancelar en estado " + estado);
        }
    }

    public String estado() {
        return estado;
    }
}
