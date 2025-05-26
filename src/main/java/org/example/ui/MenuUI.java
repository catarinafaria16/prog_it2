package org.example.ui;

import org.example.exception.MedidaInvalidaException;
import org.example.model.*;
import org.example.utils.Utils;

import java.util.List;

public class MenuUI {
    private Hospital hospital;

    public MenuUI(Hospital hospital) {
        this.hospital = hospital;
    }

    public void run() throws MedidaInvalidaException {
        int opcao;
        do {
            System.out.println("\n--- Menu de Funcionalidades ---");
            System.out.println("1. Registar profissional de saúde");
            System.out.println("2. Ler Dados de Ficheiro de Texto (CSV)");
            System.out.println("3. Adicionar Paciente");
            System.out.println("4. Adicionar Medida a Paciente");
            System.out.println("5. Visualizar Pacientes");
            System.out.println("6. Calcular Medidas Sumário");
            System.out.println("7. Visualizar Lista de Pacientes Ordenada por Ordem Alfabética");
            System.out.println("8. Alteração Percentual dos Sinais Vitais");
            System.out.println("9. Classificar Pacientes com Base na Última Medição");
            System.out.println("10. Percentagem de Pacientes em Situação Crítica");
            System.out.println("11. Visualização de Score de Gravidade");
            System.out.println("12. Imprimir Gráficos de Barras");
            System.out.println("13. Registar Dados no Ficheiro de Texto");
            System.out.println("14. Sair");
            opcao = Utils.readIntFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    RegistarProfissional.registarProfissional();
                    break;
                case 2:
                    String caminho = Utils.readLineFromConsole("Insira o caminho do ficheiro de texto: ");
                    Ficheiro.lerFicheiro(caminho);
                    break;
                case 3:
                    RegistarPaciente.registarPaciente();
                    break;
                case 4:
                    RegistarPaciente.introduzMedicoes();
                    break;
                case 5:
                    Hospital.visualizarPacientes();
                    break;
                case 6:
                    System.out.println(MedidasSumario.calcularMedidasSumarioParaTodosPacientes());
                    break;
                case 7:
                    List<Paciente> lstPacientes = ManipulacaoDados.listarPacientesOrdenados();
                    System.out.println("Lista de Pacientes (ordenados por nome e data de nascimento):");
                    for (Paciente paciente : lstPacientes) {
                        System.out.println(paciente);
                    }
                    break;
                case 8:
                    double percentualAlteracao = Utils.readDoubleFromConsole("Valor da alteração percentual (%): ");
                    ManipulacaoDados.alterarSinaisVitais(percentualAlteracao);
                    break;
                case 9:
                    Paciente.classificarPaciente(); // falta dar sout
                    break;
                case 10:
                    System.out.println("\nPercentagem de pacientes críticos: " + ManipulacaoDados.calcularPercentagemPacientesCriticos());
                    break;
                case 11:
                    Paciente.interpretarScoreGravidade();
                    System.out.println(Paciente.interpretarScoreGravidade());
                    break;
                case 12:
                    GraficoMedicoes.imprimirGrafico();
                    break;
                case 13:
                    String caminhoArquivo = Utils.readLineFromConsole("Insira o caminho do arquivo onde deseja gravar os dados: ");
                    Ficheiro.criarArquivo(caminhoArquivo);
                    break;
                case 14:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 14);
    }
}