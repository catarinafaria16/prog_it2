package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.interfaces.IMedida;
import org.example.utils.Data;

public class Medida implements IMedida {
    private Data dataRegisto;
    private Paciente paciente;
    private ProfissionalSaude profissionalSaude;
    private double valor;
    private double medida;

    public Medida(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        this.dataRegisto = dataRegisto;
        this.paciente = paciente;
        setProfissional(profissionalSaude);
    }
    public static Medida fromDouble(double medida) throws MedidaInvalidaException {
        return new Medida(medida);
    }

    @Override
    public Data getDataRegisto() {
        return dataRegisto;
    }
    @Override
    public Paciente getPaciente() {
        return paciente;
    }
    @Override
    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public Medida(double medida) {
        this.valor = valor;
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

    public void setProfissional(ProfissionalSaude profissional) {
        this.profissionalSaude = profissional;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
