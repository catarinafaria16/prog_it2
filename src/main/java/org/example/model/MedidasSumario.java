package org.example.model;

import java.util.List;

import org.example.exception.MedidaInvalidaException ;
public class MedidasSumario {
    private List<Medida> lstMedicao;
    private List<Paciente> lstPaciente ;

    public MedidasSumario(List<Medida> lstMedicao) {
        this.lstMedicao = lstMedicao;
    }

    public void calcularMedidasSumarioParaTodosPacientes() throws MedidaInvalidaException {
        for (Paciente paciente : Hospital.getLstPacientes()) {
            System.out.println("Paciente: " + paciente.getId());
            calcularMinimo(paciente);
            calcularMaximo(paciente);
            calcularMediaEDesvioPadrao(paciente);
        }
    }


    public String calcularMinimo(Paciente paciente) throws MedidaInvalidaException {
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

    public String calcularMaximo(Paciente paciente) throws MedidaInvalidaException {
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
        return "Valor máximo de frequência cardíaca: " + maxFc + "\nValor máximo de temperatura: " + maxTemp + "\nValor máximo de saturação de oxigénio: " + maxSo;
    }

    public String calcularMediaEDesvioPadrao(Paciente paciente) throws MedidaInvalidaException {
        double somaFc = 0;
        double somaQuadradosFc = 0;
        double somaTemp = 0;
        double somaQuadradosTemp = 0;
        double somaSo = 0;
        double somaQuadradosSo = 0;
        int contador = 0;
        StringBuilder resultado = new StringBuilder();

        for (Medida medida : paciente.getLstMedicao()) {
            double valor = 0;

            if (medida instanceof FrequenciaCardiaca) {
                somaFc = somaFc + ((FrequenciaCardiaca) medida).getFrequencia();
                somaQuadradosFc = somaQuadradosFc + ((FrequenciaCardiaca) medida).getFrequencia() * ((FrequenciaCardiaca) medida).getFrequencia();
            } else if (medida instanceof Temperatura) {
                somaTemp = somaTemp + ((Temperatura) medida).getTemperatura();
                somaQuadradosTemp = somaQuadradosTemp + ((Temperatura) medida).getTemperatura() * ((Temperatura) medida).getTemperatura();
            } else if (medida instanceof Saturacao) {
                somaSo = somaSo + ((Saturacao) medida).getSaturacao();
                somaQuadradosSo = somaQuadradosSo + ((Saturacao) medida).getSaturacao() * ((Saturacao) medida).getSaturacao();
            }
            contador++;
        }

        if (contador == 0) {
            throw new MedidaInvalidaException("Não há medições disponíveis.");
        } else {
            double mediaFc = somaFc / contador;
            double varianciaFc = (somaQuadradosFc / contador) - (mediaFc * mediaFc);
            double desvioPadraoFc = Math.sqrt(varianciaFc);
            resultado.append(String.format("Frequência Cardíaca - Média: %.2f, Desvio Padrão: %.2f%n", mediaFc, desvioPadraoFc));

            double mediaTemp = somaTemp / contador;
            double varianciaTemp = (somaQuadradosTemp / contador) - (mediaTemp * mediaTemp);
            double desvioPadraoTemp = Math.sqrt(varianciaTemp);
            resultado.append(String.format("Temperatura - Média: %.2f, Desvio Padrão: %.2f%n", mediaTemp, desvioPadraoTemp));
            double mediaSo = somaSo / contador;
            double varianciaSo = (somaQuadradosSo / contador) - (mediaSo * mediaSo);
            double desvioPadraoSo = Math.sqrt(varianciaSo);
            resultado.append(String.format("Saturação de Oxigênio - Média: %.2f, Desvio Padrão: %.2f%n", mediaSo, desvioPadraoSo));
        }
        return resultado.toString();
    }
    }

