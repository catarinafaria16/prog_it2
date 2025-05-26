package org.example.model;
/**
 * Classe responsável por imprimir gráficos simplificados (em formato de barras)
 * com os últimos valores de sinais vitais (frequência cardíaca, temperatura corporal e saturação de oxigénio)
 * dos pacientes registados no sistema.
 */
public class GraficoMedicoes {
    /**
     * Imprime no terminal um gráfico de barras para cada paciente registado no hospital,
     * baseado nos valores mais recentes de sinais vitais.
     * Os sinais representados são:
     * - Frequência cardíaca (bpm)
     * - Temperatura corporal (ºC)
     * - Saturação de oxigénio (%)
     *
     * A barra é representada com caracteres '*' proporcionalmente ao valor medido.
     */
    public static void imprimirGrafico() {
        try {
            for (Paciente paciente : Hospital.getLstPacientes()) {
                System.out.println("Gráfico do Paciente" +paciente.getId());
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
        } catch (NullPointerException e) {
            System.out.println("Erro ao imprimir barras: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao imprimir barras: " + e.getMessage());
        }
    }
    /**
     * Imprime uma barra de asteriscos proporcional ao valor recebido.
     *
     * @param valor  O valor a representar graficamente.
     * @param escala A escala usada para converter o valor em número de asteriscos.
     */
    private static void imprimirBarra(double valor, double escala) {
        try {
            int estrelas = (int) Math.round(valor / escala);
            for (int i = 0; i < estrelas; i++) {
                System.out.print("*");
            }
            System.out.println();
        } catch (ArithmeticException e) {
            System.out.println("Erro ao calcular estrelas: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao imprimir barra: " + e.getMessage());
        }
    }
}