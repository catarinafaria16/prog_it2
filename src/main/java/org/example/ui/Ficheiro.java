package org.example.ui;

import org.example.model.*;
import org.example.utils.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Ficheiro {
    public static List<Paciente> lerPacientes(String caminhoFicheiro) {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(","); // Supondo que os dados estão separados por vírgula
                if (dados.length == 11) { // Verifica se a linha contém todos os dados necessários
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    String sexo = dados[2].trim();
                    Data dataNascimento = Data.fromString(dados[3].trim());
                    Data dataInternamento = Data.fromString(dados[4].trim());

                    // Lê o ID, nome e especialidade do profissional de saúde
                    int idProfissional = Integer.parseInt(dados[5].trim());
                    String nomeProfissional = dados[6].trim();
                    String especialidadeProfissional = dados[7].trim();

                    // Cria o paciente com os dados lidos
                    Paciente paciente = new Paciente(id, nome, sexo, dataNascimento, dataInternamento);

                    // Cria o profissional de saúde com os dados lidos
                    ProfissionalSaude profissional = new ProfissionalSaude(idProfissional, nomeProfissional,null,null, especialidadeProfissional);

                    // Adiciona as medições, se necessário
                    paciente.adicionarMedida(new FrequenciaCardiaca(dataNascimento, paciente, profissional, Double.parseDouble(dados[8].trim())));
                    paciente.adicionarMedida(new Temperatura(dataNascimento, paciente, profissional, Double.parseDouble(dados[9].trim())));
                    paciente.adicionarMedida(new Saturacao(dataNascimento, paciente, profissional, Double.parseDouble(dados[10].trim())));

                    pacientes.add(paciente);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return pacientes;
    }
}
