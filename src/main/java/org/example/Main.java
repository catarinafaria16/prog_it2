package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Monitorização de Pacientes UCI ---");
            System.out.println("1. Visualizar pacientes");
            System.out.println("2. Alterar sinais vitais");
            System.out.println("3. Calcular score de gravidade");
            System.out.println("4. Percentagem de pacientes críticos");
            System.out.println("5. Guardar dados (serializar)");
            System.out.println("6. Carregar dados (desserializar)");
            System.out.println("7. Mostrar gráficos de barras");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[Visualizar pacientes - ainda por implementar]");
                    break;
                case 2:
                    System.out.println("[Alterar sinais vitais - ainda por implementar]");
                    break;
                case 3:
                    System.out.println("[Calcular score de gravidade - ainda por implementar]");
                    break;
                case 4:
                    System.out.println("[Percentagem críticos - ainda por implementar]");
                    break;
                case 5:
                    System.out.println("[Guardar dados - ainda por implementar]");
                    break;
                case 6:
                    System.out.println("[Carregar dados - ainda por implementar]");
                    break;
                case 7:
                    System.out.println("[Gráficos de barras - ainda por implementar]");
                    break;
                case 0:
                    System.out.println("A sair da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}