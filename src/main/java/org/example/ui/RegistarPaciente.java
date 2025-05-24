package org.example.ui;

import org.example.model.Hospital;
import org.example.model.Paciente;
import org.example.model.ProfissionalSaude;
import org.example.utils.Data;
import org.example.utils.Utils;

public class RegistarPaciente {
    private Hospital hospital;

    public RegistarPaciente(Hospital hospital) {
        this.hospital = hospital;
    }

    public void run() {
        System.out.println("Novo Paciente:");

        Paciente novoPaciente = introduzDados();
        apresentaDados(novoPaciente);

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            if (hospital.adicionarPaciente(novoPaciente)) {
                System.out.println("Dados do paciente guardados com sucesso.");
            } else {
                System.out.println("Não foi possível guardar os dados do paciente.");
            }
        }
    }

    private Paciente introduzDados() {
        int id = Utils.readIntFromConsole("Introduza o id do paciente: ");
        String nome = Utils.readLineFromConsole("Introduza o nome do paciente: ");
        String sexo = Utils.readLineFromConsole("Introduza o sexo do paciente (M/F): ");
        Data dataNascimento = Utils.readDateFromConsole("Introduza a data de nascimento (dd-MM-yyyy): ");
        Data dataInternamento = new Data(); // Pode ser a data atual ou outra lógica

        return new Paciente(id, nome, sexo, dataNascimento, dataInternamento);
    }

    private void apresentaDados(Paciente paciente) {
        System.out.println("Paciente: " + paciente.toString());
    }

    private void introduzMedicoes(Paciente paciente) {
        int idProfissional = Utils.readIntFromConsole("Introduza o ID do profissional: ");
        int id = Utils.readIntFromConsole("Introduza o id do paciente: ");
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");
        ProfissionalSaude profissional = hospital.procurarProfissionalID(idProfissional);
        if (profissional == null) {
            System.out.println("Profissional de saúde não encontrado.");
            return;
        }
    }
}

