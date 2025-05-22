package org.example.model;

import org.example.utils.Data;

import java.util.List;

public class Temperatura extends Medida {
    private double temperatura;

    public Temperatura(Data dataRegisto, double temperatura, Paciente paciente, ProfissionalSaude profissionalSaude, List<Medida> lstMedicao) {
        super(dataRegisto, paciente, profissionalSaude, lstMedicao);
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTemperatura: " + temperatura;
    }
}
