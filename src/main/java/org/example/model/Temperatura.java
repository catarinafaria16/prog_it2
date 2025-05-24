package org.example.model;

import java.util.List;

import org.example.utils.Data;

public class Temperatura extends Medida {
    private double temperatura;

    public Temperatura(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double temperatura) {
        super(dataRegisto, paciente, profissionalSaude);
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
