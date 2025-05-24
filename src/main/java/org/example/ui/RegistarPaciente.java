package org.example.ui;

import org.example.exception.MedidaInvalidaException;
import org.example.model.*;
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

    private void introduzMedicoes(Paciente paciente) throws MedidaInvalidaException {
        int idProfissional = Utils.readIntFromConsole("Introduza o ID do profissional: ");
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");

        // Procurar o profissional de saúde pelo ID
        ProfissionalSaude profissional = hospital.procurarProfissionalID(idProfissional);
        if (profissional == null) {
            throw new MedidaInvalidaException("Profissional não encontrado.");
        }

        // Verificar se o paciente existe
        Paciente p = hospital.procurarPacienteID(paciente.getId());
        if (p == null) {
            throw new MedidaInvalidaException("Paciente não encontrado.");
        }

        // Criar as medições
        FrequenciaCardiaca medidaFc = new FrequenciaCardiaca(dataRegisto, frequencia, p, profissional, p.getLstMedicao());
        Temperatura medidaTemp = new Temperatura(dataRegisto, temperatura, p, profissional, p.getLstMedicao());
        Saturacao medidaSo = new Saturacao(dataRegisto, saturacao, p, profissional, p.getLstMedicao());

        // Adicionar as medições à lista do paciente
        p.adicionarMedida(medidaFc);
        p.adicionarMedida(medidaTemp);
        p.adicionarMedida(medidaSo);

        System.out.println("Medições adicionadas com sucesso ao paciente " + p.getNome());
    }

}

