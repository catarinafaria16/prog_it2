package org.example.model;

import org.example.utils.Data;

public class ProfissionalSaude extends Pessoa {
    private String especialidade;

    public ProfissionalSaude(int id, String nome, String sexo, Data dataNascimento, String especialidade) {
        super(id, nome, sexo, dataNascimento);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Especialidade: ").append(especialidade);
        return sb.toString();
    }
}

