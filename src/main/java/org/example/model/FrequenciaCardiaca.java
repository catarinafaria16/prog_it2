package org.example.model;

import org.example.utils.Data;
import org.example.exception.MedidaInvalidaException;

/**
 * Classe que representa uma medição de frequência cardíaca, estendendo a classe {@link Medida}.
 * Esta classe inclui validações para os valores atribuídos à frequência cardíaca.
 */
public class FrequenciaCardiaca extends Medida {

    /**
     * Valor da frequência cardíaca.
     */
    protected double frequencia;

    /**
     * Construtor que inicializa uma medição de frequência cardíaca com os dados fornecidos.
     *
     * @param dataRegisto       Data em que a medição foi registrada.
     * @param paciente          Paciente ao qual a medição está associada.
     * @param profissionalSaude Profissional de saúde responsável pelo registro.
     * @param frequencia        Valor da frequência cardíaca.
     * @throws MedidaInvalidaException Se a frequência for inválida.
     */
    public FrequenciaCardiaca(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double frequencia) throws MedidaInvalidaException {
        super(dataRegisto, paciente, profissionalSaude);
        setFrequencia(frequencia);
    }

    /**
     * Construtor que inicializa uma medição de frequência cardíaca apenas com o valor da frequência.
     *
     * @param frequencia Valor da frequência cardíaca.
     * @throws MedidaInvalidaException Se a frequência for inválida.
     */
    public FrequenciaCardiaca(double frequencia) throws MedidaInvalidaException {
        super(frequencia);
        if (frequencia <= 0) {
            throw new MedidaInvalidaException("Frequência inválida.");
        }
        setFrequencia(frequencia);
    }

    /**
     * Cria uma instância de {@link FrequenciaCardiaca} a partir de um valor numérico.
     *
     * @param frequencia Valor da frequência cardíaca.
     * @return Uma nova instância de {@link FrequenciaCardiaca}.
     * @throws MedidaInvalidaException Se o valor da frequência for inválido.
     */
    public static Medida fromDouble(double frequencia) throws MedidaInvalidaException {
        return new FrequenciaCardiaca(frequencia);
    }

    /**
     * Retorna o valor da frequência cardíaca.
     *
     * @return Valor da frequência cardíaca.
     */
    public double getFrequencia() {
        return frequencia;
    }

    /**
     * Define o valor da frequência cardíaca.
     *
     * @param frequencia Valor da frequência cardíaca.
     * @throws MedidaInvalidaException Se o valor da frequência for negativo ou superior a 250.
     */
    public void setFrequencia(double frequencia) throws MedidaInvalidaException {
        if (frequencia < 0 || frequencia > 250) {
            throw new MedidaInvalidaException("Valor de frequência cardíaca inválido.");
        }
        this.frequencia = frequencia;
    }

    /**
     * Retorna uma representação textual da medição de frequência cardíaca.
     *
     * @return Uma string contendo as informações da medição.
     */
    @Override
    public String toString() {
        return super.toString() + "\nFrequência Cardíaca: " + frequencia;
    }
}
