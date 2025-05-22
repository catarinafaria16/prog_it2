package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nome;
    private final List<Paciente> lstPacientes;
    private final List<FrequenciaCardiaca> lstFreqCard;
    private final List<Temperatura> lstTemperaturas;
    private final List<Saturacao> lstSaturacoes;
    private final List<ProfissionalSaude> lstProfissionais;

    public Hospital(String nome) {
        this.nome = nome;
        this.lstPacientes = new ArrayList<>();
        this.lstFreqCard = new ArrayList<>();
        this.lstTemperaturas = new ArrayList<>();
        this.lstSaturacoes = new ArrayList<>();
        this.lstProfissionais = new ArrayList<>();
    }

    public boolean adicionarPaciente(Paciente paciente) {
        if (!listaContemPaciente(paciente.getId())) {
            lstPacientes.add(paciente);
            return true;
        }
        return false;
    }

    public void visualizarPacientes() {
        if (lstPacientes.isEmpty()) {
            System.out.println("Não há pacientes registrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : lstPacientes) {
                System.out.println(paciente);
            }
        }
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public boolean listaContemPaciente(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return true;
            }
        }
        return false;
    }
}