package org.example.model;

import java.util.List;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;

public class Temperatura extends Medida {
    private double temperatura;

    public Temperatura(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double temperatura) throws MedidaInvalidaException {
        super(dataRegisto, paciente, profissionalSaude);
        setTemperatura(temperatura);
    }
    public Temperatura (double temperatura) {
        super(temperatura);
        if (temperatura <= 0) {
            throw new IllegalArgumentException("Temperatura inválida.");
        }
        this.temperatura = temperatura;
    }

    public static Medida fromDouble(double temperatura)  {
        return new Temperatura(temperatura);
    }
    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) throws MedidaInvalidaException {
        if (temperatura < 0) {
            throw new MedidaInvalidaException("Temperatura não pode ser negativa.");
        }
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTemperatura: " + temperatura;
    }
}
