package org.example.ui;

import java.util.Scanner;

import org.example.model.Hospital;
import org.example.utils.ScoreGravidade;

public class MenuUI {
    private Hospital hospital;

    public MenuUI(Hospital hospital) {
        this.hospital = hospital;
    }

    private void mostrarGraficos() {
        hospital.getLstPacientes().forEach(paciente -> {
            System.out.println("\nPaciente: " + paciente.getNome());
            paciente.getLstMedicao().forEach(medida -> {
                org.example.model.GraficoMedicoes.imprimirBarras(medida);
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
                    calcularScore(scanner);
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void calcularScore(Scanner scanner) {
        System.out.print("ID do paciente: ");
        int id = scanner.nextInt();
        var paciente = hospital.procurarPacienteID(id);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        double fc = 0, temp = 0, spo2 = 0;
        for (var m : paciente.getLstMedicao()) {
            if (m instanceof org.example.model.FrequenciaCardiaca f)
                fc = f.getFrequencia();
            else if (m instanceof org.example.model.Temperatura t)
                temp = t.getTemperatura();
            else if (m instanceof org.example.model.Saturacao s)
                spo2 = s.getSaturacao();
        }

        double score = ScoreGravidade.calcularScore(fc, temp, spo2);
        String interpretacao = ScoreGravidade.interpretarScore(score);
        System.out.printf("Score: %.2f → %s%n", score, interpretacao);
    }
}