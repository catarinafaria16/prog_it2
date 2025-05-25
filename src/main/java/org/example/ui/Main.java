package org.example.ui;

import org.example.model.Hospital;

public class Main {
    public static void main(String[] args) {
        try {
            Hospital hospital = new Hospital("Hospital São João");
            RegistarPaciente registarPaciente = new RegistarPaciente(hospital);
            MenuUI uiMenu = new MenuUI(hospital );
            uiMenu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}