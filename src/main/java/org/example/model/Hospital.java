package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.interfaces.IHospital;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hospital implements IHospital {
    private final String hospital;
    private static List<Paciente> lstPacientes;
    private static List<ProfissionalSaude> lstProfissionais;

    public Hospital(String hospital) {
        this.hospital = hospital;
        lstPacientes = new ArrayList<>();
        lstProfissionais = new ArrayList<>();
    }

    @Override
    public boolean adicionarPaciente(Paciente paciente) {
        if (!listaContemPaciente(paciente.getId())) {
            lstPacientes.add(paciente);
            return true;
        }
        return false;
    }


    public static void adicionarFrequenciaCardiaca(Data dataRegisto, double frequencia, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        FrequenciaCardiaca medida = new FrequenciaCardiaca(dataRegisto, paciente, profissionalSaude, frequencia);
        paciente.adicionarMedida(medida);
        profissionalSaude.adicionarMedida(medida);
    }

    public static void adicionarTemperatura(Data dataRegisto, double temperatura, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        Temperatura medida = new Temperatura(dataRegisto, paciente, profissionalSaude, temperatura);
        paciente.adicionarMedida(medida);
    }

    public static void adicionarSaturacao(Data dataRegisto, double saturacao, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        Saturacao medida = new Saturacao(dataRegisto, paciente, profissionalSaude, saturacao);
        paciente.adicionarMedida(medida);
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
            System.out.println("Não há pacientes registados.");
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


    public static List<ProfissionalSaude> getLstProfissionais() {
        return lstProfissionais;
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
        final StringBuilder sb = new StringBuilder("Hospital: ").append(hospital);
        sb.append("\nLista de pacientes:").append(lstPacientes);
        sb.append("\nLista de Profissionais de Saúde: ").append(lstProfissionais);
        return sb.toString();
    }
}