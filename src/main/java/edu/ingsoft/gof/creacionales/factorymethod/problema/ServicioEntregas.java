package edu.ingsoft.gof.creacionales.factorymethod.problema;

/** DEUDA TÉCNICA: la creación del transporte está incrustada en el algoritmo. */
public class ServicioEntregas {

    public String planificarEntrega(String tipo, double km) {
        String despacho;
        double costo;
        switch (tipo) {
            case "camion" -> {
                Camion c = new Camion();
                despacho = c.cargar();
                costo = c.costoPorKm() * km;
            }
            case "barco" -> {
                Barco b = new Barco();
                despacho = b.embarcar();
                costo = b.tarifaMaritima() * km;
            }
            // Para agregar "dron" hay que modificar este método.
            default -> throw new IllegalArgumentException("Transporte desconocido: " + tipo);
        }
        return despacho + " | costo $" + String.format("%,.0f", costo);
    }
}
