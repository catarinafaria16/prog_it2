package org.example.ui;

import org.example.model.Hospital;

public class Main {
    public static void main(String[] args) {
        try {
            Hospital h = new Hospital("XYZ");
            MenuUI uiMenu = new MenuUI(h);
            uiMenu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}