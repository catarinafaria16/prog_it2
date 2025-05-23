package org.example.model;

import org.example.exception.MedidaInvalidaException;

import java.util.List;

public class MedidasSumario {
    private List<Medida> lstMedicao;

    public MedidasSumario(List<Medida> lstMedicao) {
        this.lstMedicao = lstMedicao;
    }

    public String calcularMedia() throws MedidaInvalidaException {
        double somaFc = 0;
        double somaTemp = 0;
        double somaSo = 0;
        int contador = 0;

        for (Medida medida : lstMedicao) {
            if (medida instanceof FrequenciaCardiaca) {
                somaFc += ((FrequenciaCardiaca) medida).getFrequencia();
            } else if (medida instanceof Temperatura) {
                somaTemp += ((Temperatura) medida).getTemperatura();
            } else if (medida instanceof Saturacao) {
                somaSo += ((Saturacao) medida).getSaturacao();
            }
            contador++;
        }
        if (contador == 0) {
            throw new MedidaInvalidaException("Não há medições disponíveis.");
        }
        return "Média de valores de frequência cardíaca: " + (somaFc / contador) +
                "\nMédia de valores de temperatura: " + (somaTemp / contador) +
                "\nMédia de valores de saturação de oxigénio: " + (somaSo / contador);
    }

    public String calcularMinimo(String tipo) throws MedidaInvalidaException {
        double minFc = Double.MAX_VALUE;
        double minTemp = Double.MAX_VALUE;
        double minSo = Double.MAX_VALUE;
        boolean encontrado = false;

        for (Medida medida : lstMedicao) {
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
            if (encontrado==false) {
                throw new MedidaInvalidaException("Não há medições disponíveis.");
            }
        }
        return "Valor mínimo de frequência cardíaca: " + minFc + "\nValor mínimo de temperatura: " + minTemp + "\nValor mínimo de saturação de oxigénio: " + minSo;
    }

    public String calcularMaximo(String tipo) throws MedidaInvalidaException {
        double maxFc = Double.MIN_VALUE;
        double maxTemp = Double.MIN_VALUE;
        double maxSo = Double.MIN_VALUE;
        boolean encontrado = false;

        for (Medida medida : lstMedicao) {
            if (medida instanceof FrequenciaCardiaca) {
                FrequenciaCardiaca freq = (FrequenciaCardiaca) medida;
                if (freq.getFrequencia() > maxFc) {
                    maxFc = freq.getFrequencia();
                    encontrado = true;
                }
            } else if (medida instanceof Temperatura) {
                Temperatura temp = (Temperatura) medida;
                if (temp.getTemperatura() > maxTemp) {
                    maxTemp= temp.getTemperatura();
                    encontrado = true;
                }
            } else if (medida instanceof Saturacao) {
                Saturacao sat = (Saturacao) medida;
                if (sat.getSaturacao() > maxSo) {
                    maxSo = sat.getSaturacao();
                    encontrado = true;
                }
            }
            if (encontrado==false) {
                throw new MedidaInvalidaException("Não há medições disponíveis.");
            }
            return "Valor máximo de frequência cardíaca: " + maxFc + "\nValor máximo de temperatura: " + maxTemp + "\nValor máximo de saturação de oxigénio: " + maxSo;
        }
        return "Valor máximo de frequência cardíaca: " + maxFc + "\nValor máximo de temperatura: " + maxTemp + "\nValor máximo de saturação de oxigénio: " + maxSo;
    }

    public double calcularDesvioPadraoFrequenciaCardiaca() throws MedidaInvalidaException {
        double media = calcularMedia();
        double soma = 0;
        int contador = 0;

        for (Medida medida : lstMedicao) {
            if (medida instanceof FrequenciaCardiaca) {
                soma += Math.pow(((FrequenciaCardiaca) medida).getFrequencia() - media, 2);
                contador++;
            }
        }
        return Math.sqrt(soma / contador);
    }
}
