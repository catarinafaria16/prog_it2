package org.example.model;

import org.example.utils.Data;

import java.util.List;

public class FrequenciaCardiaca extends Medida {
    private double frequencia;

    public FrequenciaCardiaca(Data dataRegisto, double frequencia, Paciente paciente, ProfissionalSaude profissionalSaude, List<Medida> lstMedicao) {
        super(dataRegisto, paciente, profissionalSaude, lstMedicao);
        this.frequencia = frequencia;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFrequência Cardíaca: " + frequencia;
    }
}

