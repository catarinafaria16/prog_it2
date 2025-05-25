package org.example.model;

import com.sun.jdi.DoubleValue;

public class GraficoMedicoes {
        public static void imprimirBarras() {
            for (Paciente paciente : Hospital.getLstPacientes()) {
                FrequenciaCardiaca ultimaFc = paciente.getUltimaFrequenciaCardiaca();
                if (ultimaFc != null) {
                    System.out.print("Frequência cardíaca (bpm): ");
                    imprimirBarra(ultimaFc.getFrequencia(), 10);
                } else {
                    System.out.println("Nenhuma medição de frequência cardíaca encontrada para o paciente " + paciente.getNome());
                }

                Temperatura ultimaTemp = paciente.getUltimaTemperatura();
                if (ultimaTemp != null) {
                    System.out.print("Temperatura corporal (ºC): ");
                    imprimirBarra(ultimaTemp.getTemperatura(), 2);
                } else {
                    System.out.println("Nenhuma medição de temperatura encontrada para o paciente " + paciente.getNome());
                }

                Saturacao ultimaSat = paciente.getUltimaSaturacaoOxigenio();
                if (ultimaSat != null) {
                    System.out.print("Saturação de oxigénio (%): ");
                    imprimirBarra(ultimaSat.getSaturacao(), 5);
                } else {
                    System.out.println("Nenhuma medição de saturação encontrada para o paciente " + paciente.getNome());
                }
            }
        }

        private static void imprimirBarra(double valor, double escala) {
            int estrelas = (int) Math.round(valor / escala);
            for (int i = 0; i < estrelas; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
