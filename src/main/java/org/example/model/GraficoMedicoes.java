package org.example.model;

public class GraficoMedicoes {

    public static void imprimirBarras(Medida medida) {
        if (medida instanceof FrequenciaCardiaca fc) {
            System.out.print("Frequência cardíaca (bpm): ");
            imprimirBarra(fc.getFrequencia());
        } else if (medida instanceof Temperatura temp) {
            System.out.print("Temperatura corporal (ºC): ");
            imprimirBarra(temp.getTemperatura());
        } else if (medida instanceof Saturacao sat) {
            System.out.print("Saturação de oxigénio (%): ");
            imprimirBarra(sat.getSaturacao());
        }
    }

    private static void imprimirBarra(double valor) {
        int estrelas = (int) Math.round(valor / 5); // ajusta escala como quiseres
        for (int i = 0; i < estrelas; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}