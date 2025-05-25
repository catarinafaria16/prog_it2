package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hospital {
    private String nome;
    private static List<Paciente> lstPacientes;
    private static List<ProfissionalSaude> lstProfissionais;

    public Hospital(String nome) {
        this.nome = nome;
        this.lstPacientes = new ArrayList<>();
        this.lstProfissionais = new ArrayList<>();
    }

    public boolean adicionarPaciente(Paciente paciente) {
        if (!listaContemPaciente(paciente.getId())) {
            lstPacientes.add(paciente);
            return true;
        }
        return false;
    }
    public static void adicionarMedidaAoPaciente(int idPaciente, Medida medida, int idProfissional) {
        ProfissionalSaude profissional = procurarProfissionalID(idProfissional);

        for (Paciente paciente : lstPacientes) {
            System.out.println("g");
            if (paciente.getId() == idPaciente) {
                // Associa o profissional à medição antes de adicionar
                paciente.adicionarMedida(medida); // Adiciona a medição ao paciente correspondente

            }
            for (Medida m:paciente.getLstMedicao()) {
                System.out.println(m);
                System.out.println("m");
            }
        }

        System.out.println("Paciente não encontrado.");
    }
    public static ProfissionalSaude procurarProfissionalID(int idProfissional) {
        for (ProfissionalSaude profissional : lstProfissionais) {
            if (profissional.getId() == idProfissional) {
                return profissional;
            }
        }
        return null; // Não encontrado
    }

    public static void visualizarPacientes() {
        if (lstPacientes.isEmpty()) {
            System.out.println("Não há pacientes registrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : lstPacientes) {
                System.out.println(paciente);
            }
        }
    }

    public Paciente procurarPacienteID(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public static List<Paciente> getLstPacientes() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hospital: ").append(nome);
        sb.append("\nLista de pacientes:").append(lstPacientes);
        sb.append("\nLista de Profissionais de Saúde: ").append(lstProfissionais);
        return sb.toString();
    }
}