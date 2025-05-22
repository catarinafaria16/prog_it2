package org.example.model;

import org.example.utils.Data;

import java.util.List;

public class Medida {
    private Data dataRegisto;
    private Paciente paciente;
    private ProfissionalSaude profissionalSaude;

    public Medida(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, List<Medida> lstMedicao) {
        this.dataRegisto = dataRegisto;
        this.paciente = paciente;
        this.profissionalSaude = profissionalSaude;
        this.lstMedicao = lstMedicao;
    }

    public Data getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Data dataRegisto) {
        this.dataRegisto = dataRegisto;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("Data do Registo=").append(dataRegisto);
        sb.append(", Paciente: ").append(paciente);
        sb.append(", Profissional de Saúde: ").append(profissionalSaude);
        return sb.toString();
    }
}
