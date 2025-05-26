package org.example.model;

import org.example.utils.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa um profissional de saúde com uma especialidade e
 * histórico de medições realizadas a pacientes.
 */
public class ProfissionalSaude extends Pessoa {
    private String especialidade;
    private static List<Medida> lstMedicao;
    /**
     * Construtor do profissional de saúde.
     *
     * @param id              Identificador único.
     * @param nome            Nome completo.
     * @param sexo            Sexo do profissional.
     * @param dataNascimento  Data de nascimento.
     * @param especialidade   Especialidade médica do profissional.
     */
    public ProfissionalSaude(int id, String nome, String sexo, Data dataNascimento, String especialidade) {
        super(id, nome, sexo, dataNascimento);
        this.especialidade = especialidade;
        lstMedicao = new ArrayList<>();
    }
    /**
     * Adiciona uma medição ao histórico deste profissional.
     *
     * @param medida Medida realizada.
     */
    public void adicionarMedida(Medida medida) {
        this.lstMedicao.add(medida);
    }

    /**
     * Representação textual do profissional, incluindo dados da classe Pessoa
     * e a especialidade.
     *
     * @return String com os dados do profissional.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Especialidade: ").append(especialidade);
        return sb.toString();
    }
}

