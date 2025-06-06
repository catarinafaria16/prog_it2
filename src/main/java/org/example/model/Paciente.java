package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.example.utils.Data;
/**
 * Representa um paciente do hospital, com dados pessoais e um histórico de medições.
 * Oferece métodos para obter informações clínicas e estatísticas com base nas últimas medições.
 */
public class Paciente extends Pessoa {
    private Data dataInternamento;
    private static List<Medida> lstMedicao;
    /**
     * Construtor do paciente.
     *
     * @param id               Identificador único.
     * @param nome             Nome completo.
     * @param sexo             Sexo do paciente.
     * @param dataNascimento   Data de nascimento.
     * @param dataInternamento Data de internamento.
     */
    public Paciente(int id, String nome, String sexo, Data dataNascimento, Data dataInternamento) {
        super(id, nome, sexo, dataNascimento);
        this.dataInternamento = new Data(dataInternamento);
        lstMedicao = new ArrayList<>();
    }

    /**
     * Obtém a última medição de frequência cardíaca do paciente.
     */
    // Método para obter a última medição de FrequenciaCardiaca
    static FrequenciaCardiaca getUltimaFrequenciaCardiaca() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof FrequenciaCardiaca) {
                return (FrequenciaCardiaca)m;
            }
        }
        return null;
    }
    /**
     * Obtém a última medição de temperatura do paciente.
     */
    // Método para obter a última medição de Temperatura
    static Temperatura getUltimaTemperatura() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof Temperatura) {
                return (Temperatura)m;
            }
        }
        return null;
    }
    /**
     * Obtém a última medição de saturação de oxigénio.
     */
    // Método para obter a última medição de SaturacaoOxigenio
    static Saturacao getUltimaSaturacaoOxigenio() {
        for (int i = lstMedicao.size() - 1; i >= 0; i--) {
            Medida m = lstMedicao.get(i);
            if (m instanceof Saturacao) {
                return (Saturacao)m;
            }
        }
        return null;
    }
    /**
     * Classifica clinicamente o paciente com base nas últimas medições:
     * Normal, Atenção ou Crítico.
     *
     * @return Classificação clínica como String.
     */
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
    /**
     * Retorna a classificação de todos os pacientes do hospital.
     */
    public static String stringClassificacao (){
        StringBuilder classificacao= new StringBuilder();
     for (Paciente p :Hospital.getLstPacientes()){
         classificarPaciente();
         classificacao.append("\nClassificação do Paciente " + p.getId());
         classificacao.append(": ");
         classificacao.append(classificarPaciente());
     }
     return (classificacao).toString();
    }
    /**
     * Calcula um score ponderado de gravidade com base nas últimas medições.
     *
     * @return Score de gravidade (double).
     */
    // Método que calcula o score de gravidade baseado nas últimas medições
    public static double calcularScoreGravidadeUltimasMedicoes() {
        int fcScore = 0;
        int tempScore = 0;
        int satScore = 0;
        for (Paciente p : Hospital.getLstPacientes()) {
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

    /**
     * Converte um valor de frequência cardíaca numa pontuação de risco.
     */
    // Métodos de pontuação - mesmas regras já usadas antes
    private static int pontuarFrequenciaCardiaca(double fc) {
        if (fc < 60) return 5;
        else if (fc <= 100) return 1;
        else if (fc <= 120) return 3;
        else return 5;
    }
    /**
     * Converte um valor de temperatura numa pontuação de risco.
     */
    private static int pontuarTemperatura(double temp) {
        if (temp < 36) return 5;
        else if (temp <= 37.5) return 1;
        else if (temp <= 39) return 3;
        else return 5;
    }
    /**
     * Converte um valor de saturação de oxigénio numa pontuação de risco.
     */
    private static int pontuarSaturacao(double spo2) {
        if (spo2 >= 95) return 1;
        else if (spo2 >= 90) return 3;
        else return 5;
    }
    /**
     * Interpreta o score de gravidade gerado, atribuindo um nível textual.
     */
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
    /**
     * Retorna o score de gravidade para todos os pacientes registados.
     */
    public static String stringScoreGravidade() {
        StringBuilder score = new StringBuilder();
        for (Paciente p : Hospital.getLstPacientes()) {
            interpretarScoreGravidade();
            score.append("\nScore de Gravidade do Paciente " + p.getId());
            score.append(": ");
            score.append(interpretarScoreGravidade());
        }
        return (score).toString();
    }
    /**
     * Adiciona uma medição ao histórico deste paciente.
     */
    public void adicionarMedida(Medida medida) {
        this.lstMedicao.add(medida);
    }
    /**
     * Devolve a lista de medições do paciente.
     */
    public List<Medida> getLstMedicao() {
        return lstMedicao;
    }
    /**
     * Obtém o ID do paciente.
     *
     * @return ID do paciente.
     */
    public int getId() {
        return id;
    }
    /**
     * Obtém o nome do paciente.
     *
     * @return Nome completo.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Obtém o sexo do paciente.
     *
     * @return Sexo (ex: "M", "F").
     */
    public String getSexo() {
        return sexo;
    }
    /**
     * Obtém a data de nascimento do paciente.
     *
     * @return Objeto {@link Data} com a data de nascimento.
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }
    /**
     * Representação textual do paciente, incluindo dados herdados de Pessoa
     * e a data de internamento.
     *
     * @return String com os dados formatados do paciente.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("DATA DE INTERNAMENTO: ").append(dataInternamento);
        return sb.toString();
    }
}

