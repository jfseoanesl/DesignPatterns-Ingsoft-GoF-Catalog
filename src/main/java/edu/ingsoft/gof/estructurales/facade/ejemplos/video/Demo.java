package edu.ingsoft.gof.estructurales.facade.ejemplos.video;

/** La fachada oculta un subsistema de conversión de video. */
public class Demo {
    public static void main(String[] args) {
        ConversorVideo conversor = new ConversorVideo();
        System.out.println(conversor.convertir("vacaciones.ogg", "mp4"));
    }
}

final class LectorArchivo {
    String abrir(String nombre) {
        return "flujo(" + nombre + ")";
    }
}

final class FabricaCodecs {
    String extraerCodec(String flujo) {
        return flujo.contains(".ogg") ? "Theora" : "H.264";
    }

    String codecPara(String formato) {
        return formato.equals("mp4") ? "H.264" : "VP9";
    }
}

final class Transcodificador {
    String transcodificar(String flujo, String origen, String destino) {
        return flujo + " [" + origen + " -> " + destino + "]";
    }
}

final class MezcladorAudio {
    String normalizar(String flujo) {
        return flujo + " +audio(AAC 128k)";
    }
}

/** Facade. */
final class ConversorVideo {
    private final LectorArchivo lector = new LectorArchivo();
    private final FabricaCodecs codecs = new FabricaCodecs();
    private final Transcodificador transcodificador = new Transcodificador();
    private final MezcladorAudio audio = new MezcladorAudio();

    String convertir(String archivo, String formato) {
        String flujo = lector.abrir(archivo);
        String origen = codecs.extraerCodec(archivo);
        String destino = codecs.codecPara(formato);
        String video = transcodificador.transcodificar(flujo, origen, destino);
        return audio.normalizar(video) + " => " + archivo.replaceAll("\\..*$", "." + formato);
    }
}
