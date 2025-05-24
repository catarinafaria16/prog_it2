package org.example.model;

import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hospital {
    private String nome;
    private final List<Paciente> lstPacientes;
    private final List<ProfissionalSaude> lstProfissionais;

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

    public void adicionarMedidaAoPaciente(int idPaciente, Medida medida) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == idPaciente) {
                paciente.adicionarMedida(medida); // Adiciona a medição ao paciente correspondente
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
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
    public void adicionarMedicoes() {
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");
        int idPaciente = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        int idProfissional = Utils.readIntFromConsole("Introduza o ID do profissional: ");

        Paciente paciente = procurarPacienteID(idPaciente);
        ProfissionalSaude profissional = procurarProfissionalID(idProfissional);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        if (profissional == null) {
            System.out.println("Profissional de saúde não encontrado.");
            return;
        }

        FrequenciaCardiaca freqCard = new FrequenciaCardiaca(dataRegisto, frequencia, paciente, profissional, lstMedicao);
        Temperatura temp = new Temperatura(dataRegisto, temperatura, paciente, profissional, lstMedicao);
        Saturacao sat = new Saturacao(dataRegisto, saturacao, paciente, profissional, lstMedicao);

        adicionarMedidaLista(freqCard);
        adicionarMedidaLista(temp);
        adicionarMedidaLista(sat);
    }

    public Paciente procurarPacienteID(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public ProfissionalSaude procurarProfissionalID(int id) {
        for (ProfissionalSaude profissionalSaude : lstProfissionais) {
            if (profissionalSaude.getId() == id) {
                return profissionalSaude;
            }
        }
        return null;
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

    public void listarProfissionaisOrdenados() {
        if (lstProfissionais.isEmpty()) {
            System.out.println("Não há profissionais de saúde registrados.");
        } else {
            // Ordenar a lista de profissionais pelo nome
            Collections.sort(lstProfissionais, new Comparator<ProfissionalSaude>() {
                @Override
                public int compare(ProfissionalSaude p1, ProfissionalSaude p2) {
                    return p1.getNome().compareToIgnoreCase(p2.getNome());
                }
            });
            System.out.println("Lista de Profissionais de Saúde (ordenados por nome):");
            for (ProfissionalSaude profissional : lstProfissionais) {
                System.out.println(profissional);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hospital: ").append(nome);
        sb.append("\nLista de pacientes:").append(lstPacientes);
        sb.append("\nLista de Medições:").append(lstMedicao);
        sb.append("\nLista de Profissionais de Saúde: ").append(lstProfissionais);
        return sb.toString();
    }
}