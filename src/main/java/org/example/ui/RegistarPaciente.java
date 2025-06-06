package org.example.ui;

import org.example.exception.MedidaInvalidaException;
import org.example.model.Hospital;
import org.example.model.Medida;
import org.example.model.Paciente;
import org.example.model.ProfissionalSaude;
import org.example.utils.Data;
import org.example.utils.Utils;
/**
 * Classe responsável pelo registo de pacientes e introdução de medições no sistema.
 */
public class RegistarPaciente  {
    private static Hospital hospital;
    /**
     * Construtor que recebe a instância do hospital atual.
     *
     * @param hospital Instância do hospital onde o paciente será registado.
     */
    public RegistarPaciente(Hospital hospital) {
        this.hospital = hospital;
    }
    /**
     * Devolve a instância atual do hospital.
     *
     * @return Hospital atual.
     */
public static Hospital getHospital() {
        return hospital;
}
    /**
     * Método principal para registar um novo paciente.
     * Solicita os dados ao utilizador e, após confirmação, tenta guardar o paciente.
     */
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

    /**
     * Solicita os dados do paciente via consola e cria uma instância de {@link Paciente}.
     *
     * @return Paciente criado com os dados introduzidos.
     */
    private static Paciente introduzDadosPaciente() {
        int id = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        String nome = Utils.readNomePaFromConsole("Introduza o nome do paciente: ");
        String sexo = Utils.readSexoFromConsole("Introduza o sexo do paciente (M/F): ");
        Data dataNascimento = Utils.readDateFromConsole("Introduza a data de nascimento (dd-MM-yyyy): ");
        Data dataInternamento = Utils.readDateFromConsole("Introduza a data de internamento (dd-MM-yyyy): ");
        return new Paciente(id, nome, sexo, dataNascimento, dataInternamento);
    }
    /**
     * Permite introduzir medições para um paciente já registado.
     * Solicita os dados necessários via consola, associa as medições ao paciente e profissional,
     * e imprime as medições introduzidas.
     *
     * @throws MedidaInvalidaException Caso algum valor de medição seja inválido.
     */
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
