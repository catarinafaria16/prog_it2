package org.example.ui;

import java.util.Scanner;

import org.example.model.Hospital;

public class MenuUI {
    private Hospital hospital;

    public MenuUI(Hospital hospital) {
        this.hospital = hospital;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu UCI ---");
            System.out.println("1. Visualizar pacientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[Pacientes: funcionalidade ainda não implementada]");
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