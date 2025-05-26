package org.example.model;

import java.util.List;

import org.example.exception.MedidaInvalidaException ;
/**
 * Classe responsável pelo cálculo de estatísticas dos sinais vitais dos pacientes,
 * incluindo valores mínimos, máximos, médias e desvios padrão.
 */
public class MedidasSumario {
    private List<Medida> lstMedicao;
    private List<Paciente> lstPaciente ;
    /**
     * Construtor que recebe uma lista de medições a ser analisada.
     *
     * @param lstMedicao Lista de medições.
     */
    public MedidasSumario(List<Medida> lstMedicao) {
        this.lstMedicao = lstMedicao;
    }
    /**
     * Calcula e retorna um resumo das medidas (mínimos, máximos, médias e desvios padrão)
     * para todos os pacientes registados.
     *
     * @return String com os resultados organizados por paciente.
     * @throws MedidaInvalidaException Se não existirem medições válidas.
     */
    public static String calcularMedidasSumarioParaTodosPacientes() throws MedidaInvalidaException {
        StringBuilder resultado = new StringBuilder();
        for (Paciente paciente : Hospital.getLstPacientes()) {
            calcularMinimo(paciente);
            calcularMaximo(paciente);
            calcularMediaEDesvioPadrao(paciente);
            resultado.append("Paciente: " + paciente.getId());
            resultado.append("\n");
            resultado.append(calcularMinimo(paciente));
            resultado.append("\n");
            resultado.append(calcularMaximo(paciente));
            resultado.append("\n");
            resultado.append(calcularMediaEDesvioPadrao(paciente));
        }
        return resultado.toString();
    }

    /**
     * Calcula os valores mínimos de cada tipo de medição (frequência, temperatura e saturação).
     *
     * @param paciente Paciente cujas medições serão analisadas.
     * @return String com os valores mínimos encontrados.
     * @throws MedidaInvalidaException Se não existirem medições.
     */
    public static String calcularMinimo(Paciente paciente) throws MedidaInvalidaException {
        double minFc = Double.MAX_VALUE;
        double minTemp = Double.MAX_VALUE;
        double minSo = Double.MAX_VALUE;
        boolean encontrado = false;

        for (Medida medida : paciente.getLstMedicao()) {
            if (medida instanceof FrequenciaCardiaca) {
                FrequenciaCardiaca freq = (FrequenciaCardiaca) medida;
                if (freq.getFrequencia() < minFc) {
                    minFc = freq.getFrequencia();
                    encontrado = true;
                }
            } else if (medida instanceof Temperatura) {
                Temperatura temp = (Temperatura) medida;
                if (temp.getTemperatura() < minTemp) {
                    minTemp = temp.getTemperatura();
                    encontrado = true;
                }
            } else if (medida instanceof Saturacao) {
                Saturacao sat = (Saturacao) medida;
                if (sat.getSaturacao() < minSo) {
                    minSo = sat.getSaturacao();
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            throw new MedidaInvalidaException("Não há medições disponíveis.");
        }
        return "Valor mínimo de frequência cardíaca: " + minFc + "\nValor mínimo de temperatura: " + minTemp + "\nValor mínimo de saturação de oxigénio: " + minSo;
    }
    /**
     * Calcula os valores máximos de cada tipo de medição.
     *
     * @param paciente Paciente cujas medições serão analisadas.
     * @return String com os valores máximos encontrados.
     * @throws MedidaInvalidaException Se não existirem medições.
     */
    public static String calcularMaximo(Paciente paciente) throws MedidaInvalidaException {
        double maxFc = Double.MIN_VALUE;
        double maxTemp = Double.MIN_VALUE;
        double maxSo = Double.MIN_VALUE;
        boolean encontrado = false;

        for (Medida medida : paciente.getLstMedicao()) {
            if (medida instanceof FrequenciaCardiaca) {
                FrequenciaCardiaca freq = (FrequenciaCardiaca) medida;
                if (freq.getFrequencia() > maxFc) {
                    maxFc = freq.getFrequencia();
                    encontrado = true;
                }
            } else if (medida instanceof Temperatura) {
                Temperatura temp = (Temperatura) medida;
                if (temp.getTemperatura() > maxTemp) {
                    maxTemp = temp.getTemperatura();
                    encontrado = true;
                }
            } else if (medida instanceof Saturacao) {
                Saturacao sat = (Saturacao) medida;
                if (sat.getSaturacao() > maxSo) {
                    maxSo = sat.getSaturacao();
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                throw new MedidaInvalidaException("Não há medições disponíveis.");
            }
        }
        return "\nValor máximo de frequência cardíaca: " + maxFc + "\nValor máximo de temperatura: " + maxTemp + "\nValor máximo de saturação de oxigénio: " + maxSo;
    }
    /**
     * Calcula a média e o desvio padrão de cada tipo de sinal vital.
     *
     * @param paciente Paciente cujas medições serão analisadas.
     * @return String com os valores calculados.
     * @throws MedidaInvalidaException Se não existirem medições válidas.
     */
    public static String calcularMediaEDesvioPadrao(Paciente paciente) throws MedidaInvalidaException {
        double somaFc = 0;
        double somaQuadradosFc = 0;
        double somaTemp = 0;
        double somaQuadradosTemp = 0;
        double somaSo = 0;
        double somaQuadradosSo = 0;
        int contador = 0;
        StringBuilder resultado = new StringBuilder();

        for (Medida medida : paciente.getLstMedicao()) {
            if (medida instanceof FrequenciaCardiaca) {
                FrequenciaCardiaca freq = (FrequenciaCardiaca) medida;
                somaFc += freq.getFrequencia();
                somaQuadradosFc += freq.getFrequencia() * freq.getFrequencia();
            } else if (medida instanceof Temperatura) {
                Temperatura temp = (Temperatura) medida;
                somaTemp += temp.getTemperatura();
                somaQuadradosTemp += temp.getTemperatura() * temp.getTemperatura();
            } else if (medida instanceof Saturacao) {
                Saturacao sat = (Saturacao) medida;
                somaSo += sat.getSaturacao();
                somaQuadradosSo += sat.getSaturacao() * sat.getSaturacao();
            }
            contador++;
        }

        if (contador==0) {
            throw new MedidaInvalidaException("Não há medições disponíveis.");
        } else {
            double mediaFc = somaFc / (contador/3);
            double varianciaFc = (somaQuadradosFc / (contador/3)) - (mediaFc * mediaFc);
            double desvioPadraoFc = Math.sqrt(varianciaFc);
            resultado.append(String.format("\nFrequência Cardíaca - Média: %.2f, Desvio Padrão: %.2f%n", mediaFc, desvioPadraoFc));
            double mediaTemp = somaTemp / (contador/3);
            double varianciaTemp = (somaQuadradosTemp / (contador/3)) - (mediaTemp * mediaTemp);
            double desvioPadraoTemp = Math.sqrt(varianciaTemp);
            resultado.append(String.format("\nTemperatura - Média: %.2f, Desvio Padrão: %.2f%n", mediaTemp, desvioPadraoTemp));
            double mediaSo = somaSo / (contador/3);
            double varianciaSo = (somaQuadradosSo / (contador/3)) - (mediaSo * mediaSo);
            double desvioPadraoSo = Math.sqrt(varianciaSo);
            resultado.append(String.format("\nSaturação de Oxigênio - Média: %.2f, Desvio Padrão: %.2f%n", mediaSo, desvioPadraoSo));
        }
        return resultado.toString();
    }

}

