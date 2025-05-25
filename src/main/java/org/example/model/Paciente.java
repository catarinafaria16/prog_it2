package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.example.utils.Data;

public class Paciente extends Pessoa {
    private Data dataInternamento;
    private static List<Medida> lstMedicao;

    public Paciente(int id, String nome, String sexo, Data dataNascimento, Data dataInternamento) {
        super(id, nome, sexo, dataNascimento);
        this.dataInternamento = dataInternamento;
        lstMedicao = new ArrayList<>();
    }

    public void adicionarMedida(Medida medida) {
        lstMedicao.add(medida);
        System.out.println("sdfghjkl");// Adiciona uma nova medição à lista do paciente
    }
    public List<Medida> getLstMedicao() {
        return lstMedicao; // Retorna a lista de medições do paciente
    }

    public Data getDataInternamento() {
        return dataInternamento;
    }

    public void setDataInternamento(Data dataInternamento) {
        this.dataInternamento = dataInternamento;
    }

    // Método para obter a última medição de FrequenciaCardiaca
    static FrequenciaCardiaca getUltimaFrequenciaCardiaca() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof FrequenciaCardiaca) {
                return (FrequenciaCardiaca)m;
            }
        }
        return null; // não encontrado
    }

    // Método para obter a última medição de Temperatura
    static Temperatura getUltimaTemperatura() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof Temperatura) {
                return (Temperatura)m;
            }
        }
        return null; // não encontrado
    }

    // Método para obter a última medição de SaturacaoOxigenio
    static Saturacao getUltimaSaturacaoOxigenio() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof Saturacao) {
                return (Saturacao)m;
            }
        }
        return null; // não encontrado
    }
    public static String classificarPaciente() {
        FrequenciaCardiaca ultimaFc = getUltimaFrequenciaCardiaca();
        Temperatura ultimaTemp = getUltimaTemperatura();
        Saturacao ultimaSat = getUltimaSaturacaoOxigenio();
        if (ultimaFc == null || ultimaTemp == null || ultimaSat == null) {
            throw new IllegalStateException("Medições incompletas para classificação.");
        }
        double fc = ultimaFc.getFrequencia();
        double temp = ultimaTemp.getTemperatura();
        double sat = ultimaSat.getSaturacao();
        if (!(fc < 60.0) && !(fc > 120.0) && !(temp < 36.0) && !(temp > 38.5) && !(sat < 90.0)) {
            return (!(fc > 100.0) || !(fc <= 120.0)) && (!(temp > 37.5) || !(temp <= 38.5)) && (!(sat >= 90.0) || !(sat < 95.0)) ? "Normal" : "Atenção";
        } else {
            return "Crítico";
        }
    }
    // Método que calcula o score de gravidade baseado nas últimas medições
    public static double calcularScoreGravidadeUltimasMedicoes() {
        int fcScore=0;
        int tempScore=0;
        int satScore=0;
        for (Paciente p: Hospital.getLstPacientes()) {
            FrequenciaCardiaca ultFc = getUltimaFrequenciaCardiaca();
            Temperatura ultTemp = getUltimaTemperatura();
            Saturacao ultSo = getUltimaSaturacaoOxigenio();

            if (ultFc == null || ultTemp == null || ultSo == null) {
                throw new IllegalStateException("Medições incompletas para cálculo do score de gravidade.");
            }

            fcScore = pontuarFrequenciaCardiaca(ultFc.getFrequencia());
            tempScore = pontuarTemperatura(ultTemp.getTemperatura());
            satScore = pontuarSaturacao(ultSo.getSaturacao());
        }
        return fcScore * 0.3 + tempScore * 0.4 + satScore * 0.3;
    }

    // Métodos de pontuação - mesmas regras já usadas antes
    private static int pontuarFrequenciaCardiaca(double fc) {
        if (fc < 60) return 5;
        else if (fc <= 100) return 1;
        else if (fc <= 120) return 3;
        else return 5;
    }

    private static int pontuarTemperatura(double temp) {
        if (temp < 36) return 5;
        else if (temp <= 37.5) return 1;
        else if (temp <= 39) return 3;
        else return 5;
    }
    private static int pontuarSaturacao(double spo2) {
        if (spo2 >= 95) return 1;
        else if (spo2 >= 90) return 3;
        else return 5;
    }
    public static String interpretarScoreGravidade() {
        double score=calcularScoreGravidadeUltimasMedicoes();
        if (score >= 1 && score <= 2) {
            return "Gravidade Baixa";
        } else if (score > 2 && score <= 3.5) {
            return "Gravidade Moderada";
        } else {
            return "Gravidade Alta";
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Data de Internamento: ").append(dataInternamento);
        return sb.toString();
    }
}

