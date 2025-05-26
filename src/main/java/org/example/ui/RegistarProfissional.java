package org.example.ui;

import org.example.model.Hospital;
import org.example.model.ProfissionalSaude;
import org.example.utils.Data;
import org.example.utils.Utils;

public class RegistarProfissional {
    protected static void registarProfissional() {
        System.out.println("Novo Profissional:");
        int id = Utils.readIntFromConsole("Introduza o ID do profissional: ");
        String nome = Utils.readNomeProFromConsole("Introduza o nome do profissional: ");
        String sexo = Utils.readSexoFromConsole("Introduza o sexo do profissional (M/F): ");
        Data dataNascimento = Utils.readDateFromConsole("Introduza a data de nascimento do profissional (dd-MM-yyyy): ");
        String especialidade = Utils.readNomeEspFromConsole("Introduza o especialidade do profissional: ");
        Hospital.getLstProfissionais().add(new ProfissionalSaude(id, nome, sexo, dataNascimento, especialidade));
    }
}
