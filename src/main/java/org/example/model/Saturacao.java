package org.example.model;

import org.example.utils.Data;

import java.util.List;

public class Saturacao extends Medida {
    private double saturacao;

    public Saturacao(Data dataRegisto, double saturacao, Paciente paciente, ProfissionalSaude profissionalSaude, List<Medida> lstMedicao) {
        super(dataRegisto, paciente, profissionalSaude, lstMedicao);
        this.saturacao = saturacao;
    }

    public double getSaturacao() {
        return saturacao;
    }

    public void setSaturacao(double saturacao) {
        this.saturacao = saturacao;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSaturação de Oxigénio: " + saturacao;
    }
}
