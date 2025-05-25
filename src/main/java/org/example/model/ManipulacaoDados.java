package org.example.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManipulacaoDados {

    public static List listarPacientesOrdenados() {
        List<Paciente> lstPacientes = Hospital.getLstPacientes();
        if (lstPacientes.isEmpty()) {
            System.out.println("Não há pacientes registrados.");
        } else {
            // Ordenar a lista de pacientes pelo nome e, em caso de empate, pela data de nascimento
            Collections.sort(lstPacientes, new Comparator<Paciente>() {
                @Override
                public int compare(Paciente p1, Paciente p2) {
                    int ComparacaoNome = p1.getNome().compareToIgnoreCase(p2.getNome());
                    if (ComparacaoNome != 0) {
                        return ComparacaoNome; // Se os nomes são diferentes, retorna a comparação
                    } else {
                        // Se os nomes são iguais, compara as datas de nascimento
                        return p1.getDataNascimento().compareTo(p2.getDataNascimento());
                    }
                }
            });
        }
        return lstPacientes;
    }

    public static void alterarSinaisVitais(double percentualAlteracao) {
        List <Paciente> lstPacientes = Hospital.getLstPacientes();
        for (Paciente paciente : lstPacientes) {
            for (Medida medida : paciente.getLstMedicao()) {
                if (medida instanceof FrequenciaCardiaca) {
                    FrequenciaCardiaca fc = (FrequenciaCardiaca) medida;
                    double novaFrequencia = fc.getFrequencia() * (1 + percentualAlteracao / 100);
                    fc.setFrequencia(novaFrequencia);
                    System.out.println("Frequência cardíaca alterada para: " + novaFrequencia + " do paciente " + paciente.getId());
                } else if (medida instanceof Temperatura) {
                    Temperatura temp = (Temperatura) medida;
                    double novaTemperatura = temp.getTemperatura() * (1 + percentualAlteracao / 100);
                    temp.setTemperatura(novaTemperatura);
                    System.out.println("Temperatura alterada para: " + novaTemperatura + " do paciente " + paciente.getId());
                } else if (medida instanceof Saturacao) {
                    Saturacao sat = (Saturacao) medida;
                    double novaSaturacao = sat.getSaturacao() * (1 + percentualAlteracao / 100);
                    sat.setSaturacao(novaSaturacao);
                    System.out.println("Saturação alterada para: " + novaSaturacao + " do paciente " + paciente.getId());
                }
            }
        }
    }
    public static double calcularPercentagemPacientesCriticos() {
        List<Paciente> lstPacientes = Hospital.getLstPacientes();
        if (lstPacientes.isEmpty()) {
            return 0.0;
        }
        int totalPacientes = lstPacientes.size();
        int pacientesCriticos = 0;
        for (Paciente paciente : lstPacientes) {
            String classificacao = paciente.classificarPaciente();
            if (classificacao.equals("Crítico")) {
                pacientesCriticos++;
            }
        }
        return (double) pacientesCriticos / totalPacientes * 100;
    }
    public static void gravarDadosEmArquivo(List<Medida> lstMedidas, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Medida medida : lstMedidas) {
                writer.write(medida.toString());
                writer.newLine(); // Adiciona uma nova linha após cada medida
            }
            System.out.println("Dados gravados com sucesso em " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
