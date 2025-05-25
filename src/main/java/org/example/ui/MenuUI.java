package org.example.ui;

import java.util.Scanner;

import org.example.model.Hospital;

public class MenuUI {
    private Hospital hospital;

    public MenuUI(Hospital hospital) {
        this.hospital = hospital;
    }

    private void mostrarGraficos() {
        hospital.getLstPacientes().forEach(paciente -> {
            System.out.println("\nPaciente: " + paciente.getNome());
            paciente.getLstMedicao().forEach(medida -> {
                org.example.model.GraficoMedicoes.imprimirBarras();
            });
        });
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu UCI ---");
            System.out.println("1. Visualizar pacientes");
            System.out.println("2. Mostrar gráficos de medições");
            System.out.println("3. Calcular score de gravidade");
            System.out.println("4. Percentagem de Pacientes em Situação Crítica ");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[Pacientes: funcionalidade ainda não implementada]");
                    break;
                case 2:
                    mostrarGraficos();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}