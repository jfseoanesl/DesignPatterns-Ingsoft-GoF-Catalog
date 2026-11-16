package edu.ingsoft.gof.estructurales.adapter.solucion;

public class Demo {
    public static void main(String[] args) {
        ProcesadorPagos real = new AdaptadorPasarelaXml(new PasarelaLegadaXml());
        ServicioCheckout checkout = new ServicioCheckout(real);
        System.out.println(checkout.finalizarCompra("cliente-7", 150_000));
        System.out.println(checkout.finalizarCompra("cliente-8", 0));
        System.out.println("Reembolso: " + real.reembolsar("TX1000", 150_000));

        // Doble de prueba: el checkout se prueba sin la pasarela real
        ProcesadorPagos simulado = new ProcesadorPagos() {
            @Override
            public ResultadoPago cobrar(Pago p) {
                return new ResultadoPago(true, "TEST-1");
            }

            @Override
            public ResultadoPago reembolsar(String tx, long v) {
                return new ResultadoPago(true, tx);
            }
        };
        System.out.println("Con simulado: "
                + new ServicioCheckout(simulado).finalizarCompra("x", 1));
    }
}
