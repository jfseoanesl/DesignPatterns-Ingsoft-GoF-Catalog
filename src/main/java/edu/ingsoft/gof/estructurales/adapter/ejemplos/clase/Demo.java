package edu.ingsoft.gof.estructurales.adapter.ejemplos.clase;

/** Adaptador de clases: hereda del Adaptee e implementa el Target. */
public class Demo {
    public static void main(String[] args) {
        SensorCelsius sensor = new AdaptadorSensor(98.6);
        System.out.printf("Temperatura: %.1f °C%n", sensor.celsius());
        Termostato t = new Termostato(sensor);
        System.out.println(t.evaluar());
    }
}

/** Target. */
interface SensorCelsius {
    double celsius();
}

/** Adaptee heredado (no modificable). */
class SensorFahrenheitLegado {
    private final double fahrenheit;

    SensorFahrenheitLegado(double f) {
        this.fahrenheit = f;
    }

    double leerFahrenheit() {
        return fahrenheit;
    }
}

/** Adapter de clases. */
class AdaptadorSensor extends SensorFahrenheitLegado implements SensorCelsius {
    AdaptadorSensor(double f) {
        super(f);
    }

    @Override
    public double celsius() {
        return (leerFahrenheit() - 32) * 5 / 9;
    }
}

final class Termostato {
    private final SensorCelsius sensor;

    Termostato(SensorCelsius s) {
        this.sensor = s;
    }

    String evaluar() {
        return sensor.celsius() > 37.5 ? "Fiebre: activar alerta" : "Temperatura normal";
    }
}
