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
            System.out.println("1. Ler Dados de Ficheiro de Texto (CSV)");
            System.out.println("2. Adicionar Paciente");
            System.out.println("3. Adicionar Medida a Paciente");
            System.out.println("4. Visualizar Pacientes");
            System.out.println("5. Calcular Medidas Sumário");
            System.out.println("6. Visualizar Lista de Pacientes Ordenada por Ordem Alfabética");
            System.out.println("7. Alteração Percentual dos Sinais Vitais");
            System.out.println("8. Classificar Pacientes com Base na Última Medição");
            System.out.println("9. Percentagem de Pacientes em Situação Crítica");
            System.out.println("10. Visualização de Score de Gravidade");
            System.out.println("11. Imprimir Gráficos de Barras");
            System.out.println("12. Registar Dados no Ficheiro de Texto");
            System.out.println("13. Sair");
            opcao = Utils.readIntFromConsole("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    String caminho = Utils.readLineFromConsole("Insira o caminho do ficheiro de texto: ");
                    Ficheiro.lerFicheiro(caminho);
                    break;
                case 2:
                    RegistarPaciente.registarPaciente();
                    break;
                case 3:
                    RegistarPaciente.introduzMedicoes();
                    break;
                case 4:
                    Hospital.visualizarPacientes();
                    break;
                case 5:
                    MedidasSumario.calcularMedidasSumarioParaTodosPacientes();
                    break;
                case 6:
                    List<Paciente> lstPacientes = ManipulacaoDados.listarPacientesOrdenados();
                    System.out.println("Lista de Pacientes (ordenados por nome e data de nascimento):");
                    for (Paciente paciente : lstPacientes) {
                        System.out.println(paciente);
                    }
                    break;
                case 7:
                    double percentualAlteracao = Utils.readDoubleFromConsole("Valor da alteração percentual (%): ");
                    ManipulacaoDados.alterarSinaisVitais(percentualAlteracao);
                    break;
                case 8:
                    Paciente.classificarPaciente(); // falta dar sout
                    break;
                case 9:
                    System.out.println("\nPercentagem de pacientes críticos: " + ManipulacaoDados.calcularPercentagemPacientesCriticos());
                    break;
                case 10:
                    Paciente.interpretarScoreGravidade();
                    break;
                case 11:
                    GraficoMedicoes.imprimirGrafico();
                    break;
                case 12:
                    String caminhoArquivo = Utils.readLineFromConsole("Insira o caminho do arquivo onde deseja gravar os dados: ");
                    Ficheiro.criarArquivo(caminhoArquivo);
                    break;
                case 13:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 13);
    }
}