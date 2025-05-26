package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.interfaces.IHospital;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Representa um hospital que gere listas de pacientes e profissionais de saúde,
 * e permite o registo e manipulação de medições dos pacientes.
 */
public class Hospital implements IHospital {
    private final String hospital;
    private static List<Paciente> lstPacientes;
    private static List<ProfissionalSaude> lstProfissionais;
    /**
     * Construtor da classe Hospital.
     *
     * @param hospital Nome do hospital.
     */
    public Hospital(String hospital) {
        this.hospital = hospital;
        lstPacientes = new ArrayList<>();
        lstProfissionais = new ArrayList<>();
    }
    /**
     * Adiciona um paciente à lista de pacientes, caso ainda não esteja registado.
     *
     * @param paciente Paciente a ser adicionado.
     * @return true se adicionado com sucesso; false se já existia.
     */
    @Override
    public boolean adicionarPaciente(Paciente paciente) {
        if (!listaContemPaciente(paciente.getId())) {
            lstPacientes.add(paciente);
            return true;
        }
        return false;
    }

    /**
     * Regista uma medição de frequência cardíaca.
     *
     * @param dataRegisto       Data da medição.
     * @param frequencia        Valor da frequência.
     * @param paciente          Paciente a quem a medição pertence.
     * @param profissionalSaude Profissional responsável pela medição.
     * @throws MedidaInvalidaException Se o valor da medição for inválido.
     */
    public static void adicionarFrequenciaCardiaca(Data dataRegisto, double frequencia, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        FrequenciaCardiaca medida = new FrequenciaCardiaca(dataRegisto, paciente, profissionalSaude, frequencia);
        paciente.adicionarMedida(medida);
        profissionalSaude.adicionarMedida(medida);
    }
    /**
     * Regista uma medição de temperatura corporal.
     *
     * @param dataRegisto       Data da medição.
     * @param temperatura       Valor da temperatura.
     * @param paciente          Paciente a quem a medição pertence.
     * @param profissionalSaude Profissional responsável.
     * @throws MedidaInvalidaException Se o valor da medição for inválido.
     */
    public static void adicionarTemperatura(Data dataRegisto, double temperatura, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        Temperatura medida = new Temperatura(dataRegisto, paciente, profissionalSaude, temperatura);
        paciente.adicionarMedida(medida);
    }
    /**
     * Regista uma medição de saturação de oxigénio.
     *
     * @param dataRegisto       Data da medição.
     * @param saturacao         Valor da saturação.
     * @param paciente          Paciente a quem a medição pertence.
     * @param profissionalSaude Profissional responsável.
     * @throws MedidaInvalidaException Se o valor da medição for inválido.
     */
    public static void adicionarSaturacao(Data dataRegisto, double saturacao, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        Saturacao medida = new Saturacao(dataRegisto, paciente, profissionalSaude, saturacao);
        paciente.adicionarMedida(medida);
    }
    /**
     * Procura um profissional de saúde pelo seu ID.
     *
     * @param idProfissional ID do profissional.
     * @return Objeto ProfissionalSaude, ou null se não for encontrado.
     */
    public static ProfissionalSaude procurarProfissionalID(int idProfissional) {
        for (ProfissionalSaude profissional : lstProfissionais) {
            if (profissional.getId() == idProfissional) {
                return profissional;
            }
        }
        return null; // Não encontrado
    }
    /**
     * Mostra todos os pacientes registados no hospital.
     * Imprime diretamente para a consola.
     */
    public static void visualizarPacientes() {
        if (lstPacientes.isEmpty()) {
            System.out.println("Não há pacientes registados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : lstPacientes) {
                System.out.println(paciente);
            }
        }
    }
    /**
     * Procura um paciente pelo seu ID.
     *
     * @param id ID do paciente.
     * @return Objeto Paciente, ou null se não for encontrado.
     */
    public Paciente procurarPacienteID(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }
    /**
     * Obtém a lista de todos os pacientes registados.
     *
     * @return Lista de pacientes.
     */
    public static List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    /**
     * Obtém a lista de profissionais de saúde registados.
     *
     * @return Lista de profissionais.
     */
    public static List<ProfissionalSaude> getLstProfissionais() {
        return lstProfissionais;
    }
    /**
     * Verifica se a lista de pacientes já contém um paciente com o ID indicado.
     *
     * @param id ID do paciente.
     * @return true se o paciente já existe, false caso contrário.
     */
    public boolean listaContemPaciente(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return true;
            }
        }
        return false;
    }
    /**
     * Representação textual do hospital, incluindo listas de pacientes e profissionais.
     *
     * @return String formatada com informações do hospital.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hospital: ").append(hospital);
        sb.append("\nLista de pacientes:").append(lstPacientes);
        sb.append("\nLista de Profissionais de Saúde: ").append(lstProfissionais);
        return sb.toString();
    }
}