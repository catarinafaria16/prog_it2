package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.interfaces.IMedida;
import org.example.utils.Data;

/**
 * Representa uma medida associada a um paciente e a um profissional de saúde.
 * Esta classe implementa a interface {@link IMedida} para padronizar as operações
 * relacionadas a medidas clínicas.
 */
public class Medida implements IMedida {
    /**
     * Data do registro da medida.
     */
    private Data dataRegisto;
    /**
     * Paciente ao qual a medida está associada.
     */
    private Paciente paciente;
    /**
     * Profissional de saúde responsável pelo registro da medida.
     */
    private ProfissionalSaude profissionalSaude;
    /**
     * Valor bruto da medida.
     */
    private double valor;

    /**
     * Constrói uma nova instância de {@link Medida}.
     *
     * @param dataRegisto          A data em que a medida foi registrada.
     * @param paciente             O paciente associado à medida.
     * @param profissionalSaude    O profissional de saúde que realizou a medida.
     * @throws MedidaInvalidaException Se algum parâmetro for inválido.
     */
    public Medida(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude) throws MedidaInvalidaException {
        setDataRegisto(dataRegisto);
        setPaciente(paciente);
        setProfissional(profissionalSaude);
    }

    /**
     * Cria uma instância de {@link Medida} a partir de um valor numérico.
     *
     * @param medida O valor da medida.
     * @return Uma nova instância de {@link Medida}.
     * @throws MedidaInvalidaException Se o valor da medida for inválido.
     */
    public static Medida fromDouble(double medida) throws MedidaInvalidaException {
        return new Medida(medida);
    }

    /**
     * Retorna a data do registro da medida.
     *
     * @return A data do registro.
     */
    @Override
    public Data getDataRegisto() {
        return dataRegisto;
    }

    /**
     * Retorna o paciente associado à medida.
     *
     * @return O paciente associado.
     */
    @Override
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Retorna o profissional de saúde responsável pela medida.
     *
     * @return O profissional de saúde responsável.
     */
    @Override
    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public Medida(double medida) {
        this.valor = medida;
    }

    /**
     * Define a data do registro da medida.
     *
     * @param dataRegisto A nova data do registro.
     * @throws IllegalArgumentException Se a data for nula.
     */
    public void setDataRegisto(Data dataRegisto) {
        if (dataRegisto == null) {
            throw new IllegalArgumentException("A data do registro não pode ser nula.");
        }
        this.dataRegisto = dataRegisto;
    }

    /**
     * Define o profissional de saúde responsável pela medida.
     *
     * @param profissional O profissional de saúde a ser associado.
     * @throws IllegalArgumentException Se o profissional for nulo.
     */
    public void setProfissional(ProfissionalSaude profissional) {
        if (profissional == null) {
            throw new IllegalArgumentException("O profissional de saúde não pode ser nulo.");
        }
        this.profissionalSaude = profissional;
    }

    /**
     * Define o paciente associado à medida.
     *
     * @param paciente O paciente a ser associado.
     * @throws IllegalArgumentException Se o paciente for nulo.
     */
    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("O paciente não pode ser nulo.");
        }
        this.paciente = paciente;
    }

    /**
     * Retorna uma representação textual da medida.
     *
     * @return Uma string contendo as informações da medida.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("Data do Registo=").append(dataRegisto);
        sb.append(", Paciente: ").append(paciente);
        sb.append(", Profissional de Saúde: ").append(profissionalSaude);
        return sb.toString();
    }
}
