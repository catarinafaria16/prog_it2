package org.example.model;

import org.example.utils.Data;
import org.example.exception.MedidaInvalidaException;
public class FrequenciaCardiaca extends Medida {
    private double frequencia;

    public FrequenciaCardiaca(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double frequencia) throws MedidaInvalidaException {
        super(dataRegisto, paciente, profissionalSaude);
        setFrequencia(frequencia);
    }

    public FrequenciaCardiaca(double frequencia) throws MedidaInvalidaException {
        super(frequencia);
        if (frequencia <= 0) {
            throw new IllegalArgumentException("Frequência inválida.");
        }
        setFrequencia(frequencia);
    }

    public static Medida fromDouble(double frequencia) throws MedidaInvalidaException {
    return new FrequenciaCardiaca(frequencia);
}


    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) throws MedidaInvalidaException {
        if (frequencia < 0) {
            throw new MedidaInvalidaException("Frequência cardíaca não pode ser negativa.");
        }
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFrequência Cardíaca: " + frequencia;
    }
}
