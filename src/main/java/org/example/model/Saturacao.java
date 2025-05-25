package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;

public class Saturacao extends Medida {
    private double saturacao;

    public Saturacao(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double saturacao) {
        super(dataRegisto, paciente, profissionalSaude);
        this.saturacao = saturacao;
    }
    public Saturacao(double saturacao) {
        super(saturacao);
        if (saturacao <= 0) {
            throw new IllegalArgumentException("Saturação de oxigénio inválida.");
        }
        this.saturacao = saturacao;
    }

    public static Medida fromDouble(double saturacao)  {
        return new Saturacao(saturacao);
    }

    public double getSaturacao() {
        return saturacao;
    }

    public void setSaturacao(double saturacao) throws MedidaInvalidaException {
        if (saturacao < 0) {
            throw new MedidaInvalidaException("A saturação de oxigénio não pode ser negativa.");
        }
        this.saturacao = saturacao;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSaturação de Oxigénio: " + saturacao;
    }
}
