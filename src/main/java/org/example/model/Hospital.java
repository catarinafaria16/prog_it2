package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hospital {
    private String nome;
    private final List<Paciente> lstPacientes;
    private final List<ProfissionalSaude> lstProfissionais;
    private final List<Medida> lstMedicao;

    public Hospital(String nome) {
        this.nome = nome;
        this.lstMedicao = new ArrayList<>();
        this.lstPacientes = new ArrayList<>();
        this.lstProfissionais = new ArrayList<>();
    }

    public boolean adicionarPaciente(Paciente paciente) {
        if (!listaContemPaciente(paciente.getId())) {
            lstPacientes.add(paciente);
            return true;
        }
        return false;
    }

    public void adicionarMedidaLista(Medida medida) {
        lstMedicao.add(medida);
    }

    public void visualizarPacientes() {
        if (lstPacientes.isEmpty()) {
            System.out.println("Não há pacientes registrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : lstPacientes) {
                System.out.println(paciente);
            }
        }
    }
    public void adicionarMedicoes() {
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");
        int idPaciente = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        int idProfissional = Utils.readIntFromConsole("Introduza o ID do profissional: ");

        Paciente paciente = procurarPacienteID(idPaciente);
        ProfissionalSaude profissional = procurarProfissionalID(idProfissional);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        if (profissional == null) {
            System.out.println("Profissional de saúde não encontrado.");
            return;
        }

        FrequenciaCardiaca freqCard = new FrequenciaCardiaca(dataRegisto, frequencia, paciente, profissional, lstMedicao);
        Temperatura temp = new Temperatura(dataRegisto, temperatura, paciente, profissional, lstMedicao);
        Saturacao sat = new Saturacao(dataRegisto, saturacao, paciente, profissional, lstMedicao);

        adicionarMedidaLista(freqCard);
        adicionarMedidaLista(temp);
        adicionarMedidaLista(sat);
    }

    public Paciente procurarPacienteID(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public ProfissionalSaude procurarProfissionalID(int id) {
        for (ProfissionalSaude profissionalSaude : lstProfissionais) {
            if (profissionalSaude.getId() == id) {
                return profissionalSaude;
            }
        }
        return null;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public boolean listaContemPaciente(int id) {
        for (Paciente paciente : lstPacientes) {
            if (paciente.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void adicionarFrequenciaCardiaca() {
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double frequencia = Utils.readDoubleFromConsole("Introduza a frequência cardíaca: ");
        int idPaciente = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        int idTecnico = Utils.readIntFromConsole("Introduza o ID do técnico: ");
        // Obter paciente e técnico com base nos IDs
        // hospital.adicionarFreqCardiaca(dataRegisto, frequencia, paciente, tecnico);
    }

    private void adicionarTemperatura() {
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double temperatura = Utils.readDoubleFromConsole("Introduza a temperatura: ");
        int idPaciente = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        int idTecnico = Utils.readIntFromConsole("Introduza o ID do técnico: ");
        // Obter paciente e técnico com base nos IDs
        // hospital.adicionarTemperatura(dataRegisto, temperatura, paciente, tecnico);
    }

    private void adicionarSaturacao() {
        Data dataRegisto = Utils.readDateFromConsole("Introduza a data da medição (dd-MM-yyyy): ");
        double saturacao = Utils.readDoubleFromConsole("Introduza a saturação: ");
        int idPaciente = Utils.readIntFromConsole("Introduza o ID do paciente: ");
        int idTecnico = Utils.readIntFromConsole("Introduza o ID do técnico: ");
        // Obter paciente e técnico com base nos IDs
        // hospital.adicionarSaturacao(dataRegisto, saturacao, paciente, tecnico);
    }

    private String calcularMedia(List<Medida> lstMedicao) throws MedidaInvalidaException {
        double somaFc = 0;
        double somaTemp = 0;
        double somaSo = 0;
        int contador = 0;

        for (Medida medida : lstMedicao) {
            // Verifica se a medida é do tipo esperado e extrai o valor
            if (medida instanceof FrequenciaCardiaca) {
                somaFc += ((FrequenciaCardiaca) medida).getFrequencia();
            } else if (medida instanceof Temperatura) {
                somaTemp += ((Temperatura) medida).getTemperatura();
            } else if (medida instanceof Saturacao) {
                somaSo += ((Saturacao) medida).getSaturacao();
            }
            contador++;
        }
        if (contador == 0) {
            throw new MedidaInvalidaException("Não há medições disponíveis.");
        }
        return "Média de valores de frequência cardíaca: " + somaFc / contador + "\nMédia de valores de temperatura: " + somaTemp / contador + "\nMédia de valores de saturação de oxigénio: " + somaSo / contador;
    }

    public double calcularDesvioPadraoFrequenciaCardiaca() {
        double media = calcularMediaFrequenciaCardiaca();
        double soma = 0;
        for (FrequenciaCardiaca freq : lstFreqCard) {
            soma += Math.pow(freq.getFrequencia() - media, 2);
        }
        return Math.sqrt(soma / lstFreqCard.size());
    }

    public double calcularMinimoFrequenciaCardiaca() {
        double min = Double.MAX_VALUE;
        for (FrequenciaCardiaca freq : lstFreqCard) {
            if (freq.getFrequencia() < min) {
                min = freq.getFrequencia();
            }
        }
        return min;
    }

    public double calcularMaximoFrequenciaCardiaca() {
        double max = Double.MIN_VALUE;
        for (FrequenciaCardiaca freq : lstFreqCard) {
            if (freq.getFrequencia() > max) {
                max = freq.getFrequencia();
            }
        }
        return max;
    }

    public void listarProfissionaisOrdenados() {
        if (lstProfissionais.isEmpty()) {
            System.out.println("Não há profissionais de saúde registrados.");
        } else {
            // Ordenar a lista de profissionais pelo nome
            Collections.sort(lstProfissionais, new Comparator<ProfissionalSaude>() {
                @Override
                public int compare(ProfissionalSaude p1, ProfissionalSaude p2) {
                    return p1.getNome().compareToIgnoreCase(p2.getNome());
                }
            });
            System.out.println("Lista de Profissionais de Saúde (ordenados por nome):");
            for (ProfissionalSaude profissional : lstProfissionais) {
                System.out.println(profissional);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hospital: ").append(nome);
        sb.append("\nLista de pacientes:").append(lstPacientes);
        sb.append("\nLista de Medições:").append(lstMedicao);
        sb.append("\nLista de Profissionais de Saúde: ").append(lstProfissionais);
        return sb.toString();
    }
}