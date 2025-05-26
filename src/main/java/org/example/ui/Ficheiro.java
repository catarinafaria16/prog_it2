package org.example.ui;

import org.example.exception.MedidaInvalidaException;
import org.example.model.*;
import org.example.utils.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela manipulação de arquivos para leitura e gravação
 * de dados relacionados a pacientes e medições.
 */
public class Ficheiro {

    /**
     * Lê os dados de um arquivo e cria objetos de pacientes e suas medições.
     *
     * @param caminhoFicheiro Caminho do arquivo a ser lido.
     * @return Lista de pacientes lidos do arquivo.
     */
    public static List<Paciente> lerFicheiro(String caminhoFicheiro) {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");// Supondo que os dados estão separados por vírgula
                if (dados.length == 14) {// Verifica se a linha contém todos os dados necessários
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    String sexo = dados[2].trim();
                    Data dataNascimento = Data.fromString(dados[3].trim());
                    Data dataRegisto= Data.fromString(dados[4].trim());
                    Data dataInternamento = Data.fromString(dados[5].trim());
                    // Lê o ID, nome e especialidade do profissional de saúde
                    int idProfissional = Integer.parseInt(dados[6].trim());
                    String nomeProfissional = dados[7].trim();
                    String sexoProfissional = dados[8].trim();
                    Data dataNascimentoProfissional = Data.fromString(dados[9].trim());
                    String especialidadeProfissional = dados[10].trim();
                    // Cria o paciente com os dados lidos
                    Paciente paciente = new Paciente(id, nome, sexo, dataNascimento, dataInternamento);
                    // Cria o profissional de saúde com os dados lidos
                    ProfissionalSaude profissional = new ProfissionalSaude(idProfissional, nomeProfissional, sexoProfissional, dataNascimentoProfissional, especialidadeProfissional);
                    Hospital.getLstProfissionais().add(profissional);
                    RegistarPaciente.getHospital().adicionarPaciente(paciente);
                    // Adiciona as medições, se necessário
                    Hospital.adicionarFrequenciaCardiaca(dataRegisto, Double.parseDouble(dados[11].trim()), paciente,profissional);
                    Hospital.adicionarTemperatura(dataRegisto, Double.parseDouble(dados[12].trim()), paciente,profissional);
                    Hospital.adicionarSaturacao(dataRegisto, Double.parseDouble(dados[13].trim()), paciente,profissional);
                    pacientes.add(paciente);

                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ficheiro: " + e.getMessage());
        } catch (MedidaInvalidaException e) {
            System.err.println("Erro ao processar medições: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores numéricos: " + e.getMessage());
        }

        return pacientes;
    }

    /**
     * Cria um arquivo com os dados dos pacientes e suas medições.
     *
     * @param caminhoArquivo Caminho do arquivo a ser criado.
     */
    public static void criarArquivo(String caminhoArquivo) {
        for (Paciente p : Hospital.getLstPacientes()) {
            List<Medida> lstMedicao = p.getLstMedicao();
            ManipulacaoDados.gravarDadosEmArquivo(lstMedicao, caminhoArquivo);
        }
    }
}
