package edu.ingsoft.gof.comportamiento.templatemethod.problema;

public class Demo {
    public static void main(String[] args) {
        String csv = "# sku,precio\nA1,1500\nA2,-30\nA3,800";
        String json = "[{\"sku\":\"A1\",\"precio\":1500},{\"sku\":\"A2\",\"precio\":-30},"
                + "{\"sku\":\"A3\",\"precio\":800}]";
        System.out.println(new ImportadorCsv().importar(csv));
        System.out.println(new ImportadorJson().importar(json) + "   <- inconsistente");
    }
}
