package edu.ingsoft.gof.estructurales.adapter.ejemplos.colecciones;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/** Adaptadores reales del JDK. */
public class Demo {
    public static void main(String[] args) throws IOException {
        // 1) Arrays.asList: arreglo -> List (vista adaptada, respaldada por el arreglo)
        String[] arreglo = {"c", "a", "b"};
        List<String> vista = Arrays.asList(arreglo);
        Collections.sort(vista);
        System.out.println("Arreglo ordenado vía List: " + Arrays.toString(arreglo));

        // 2) InputStreamReader: bytes (InputStream) -> caracteres (Reader)
        byte[] bytes = "línea 1\nlínea 2".getBytes(StandardCharsets.UTF_8);
        try (BufferedReader r = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(bytes), StandardCharsets.UTF_8))) {
            System.out.println("Leído como texto: " + r.readLine());
        }

        // 3) Collections.enumeration: Collection -> Enumeration (API heredada)
        Enumeration<String> e = Collections.enumeration(List.of("x", "y"));
        StringBuilder sb = new StringBuilder();
        while (e.hasMoreElements()) {
            sb.append(e.nextElement());
        }
        System.out.println("Recorrido con Enumeration: " + sb);
    }
}
