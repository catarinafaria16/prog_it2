package org.example.ui;

import org.example.model.Hospital;

/**
 * Classe principal que inicializa o sistema hospitalar.
 * Configura o hospital e inicia a interface do menu.
 */
public class Main {

    /**
     * Método principal que serve como ponto de entrada para o programa.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            // Criação da instância do hospital
            Hospital hospital = new Hospital("Hospital São João");

            // Inicialização do registo de pacientes
            RegistarPaciente registarPaciente = new RegistarPaciente(hospital);

            // Inicialização da interface do menu de funcionalidades
            MenuUI uiMenu = new MenuUI(hospital );
            uiMenu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}