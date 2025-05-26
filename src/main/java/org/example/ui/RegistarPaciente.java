package org.example.ui;

import org.example.exception.MedidaInvalidaException;
import org.example.model.FrequenciaCardiaca;
import org.example.model.Hospital;
import org.example.model.Medida;
import org.example.model.Paciente;
import org.example.model.ProfissionalSaude;
import org.example.model.Saturacao;
import org.example.model.Temperatura;
import org.example.utils.Data;
import org.example.utils.Utils;

public class RegistarPaciente  {
    private static Hospital hospital;

    public RegistarPaciente(Hospital hospital) {
        this.hospital = hospital;
    }

public static Hospital getHospital() {
        return hospital;
}
    public static void registarPaciente() {
        System.out.println("Novo Paciente:");
        Paciente novoPaciente = introduzDadosPaciente();

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            if (hospital.adicionarPaciente(novoPaciente)) {
                System.out.println("Dados do paciente guardados com sucesso.");
            } else {
                System.out.println("Não foi possível guardar os dados do paciente.");
            }
        }
    }


    private static Paciente introduzDadosPaciente() {
        int id = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        String nome = Utils.readLineFromConsole("Introduza o nome do paciente: ");
        String sexo = Utils.readSexoFromConsole("Introduza o sexo do paciente (M/F): ");
        Data dataNascimento = Utils.readDateFromConsole("Introduza a data de nascimento (dd-MM-yyyy): ");
        Data dataInternamento = Utils.readDateFromConsole("Introduza a data de internamento (dd-MM-yyyy): ");
        return new Paciente(id, nome, sexo, dataNascimento, dataInternamento);
    }

    static void introduzMedicoes() throws MedidaInvalidaException {
        int idProfissional = Utils.readIntFromConsole("Introduza o ID do profissional: ");
        int id = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");
        ProfissionalSaude profissional = hospital.procurarProfissionalID(idProfissional);
        if (profissional == null) {
            System.out.println("Profissional não encontrado.");
            return;
        }
        System.out.println(profissional);
        Paciente paciente = hospital.procurarPacienteID(id);
        Hospital.adicionarFrequenciaCardiaca(dataRegisto, frequencia, paciente, profissional);
        Hospital.adicionarTemperatura(dataRegisto, temperatura, paciente, profissional);
        Hospital.adicionarSaturacao(dataRegisto,saturacao, paciente, profissional);
        for (Medida m :paciente.getLstMedicao()){
            System.out.println(m);
        }
    }
}
