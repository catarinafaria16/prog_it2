package org.example.model;

import org.example.utils.Data;

public class Saturacao extends Medida {
    private double saturacao;

    public Saturacao(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double saturacao) {
        super(dataRegisto, paciente, profissionalSaude);
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
