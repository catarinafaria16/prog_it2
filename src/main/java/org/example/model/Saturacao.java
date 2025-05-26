package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;

/**
 * Representa uma medição de saturação de oxigénio de um paciente, estendendo a classe {@link Medida}.
 */
public class Saturacao extends Medida {

    /**
     * Valor da saturação de oxigénio registada.
     */
    private double saturacao;

    /**
     * Constrói uma instância de {@link Saturacao}.
     *
     * @param dataRegisto       Data da medição.
     * @param paciente          Paciente associado.
     * @param profissionalSaude Profissional de saúde responsável pela medição.
     * @param saturacao         Valor da saturação de oxigénio.
     * @throws MedidaInvalidaException Se o valor da saturação for inválido.
     */
    public Saturacao(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double saturacao) throws MedidaInvalidaException {
        super(dataRegisto, paciente, profissionalSaude);
        setSaturacao(saturacao);
    }

    /**
     * Constrói uma instância de {@link Saturacao} com apenas o valor da saturação.
     *
     * @param saturacao Valor da saturação de oxigénio.
     * @throws MedidaInvalidaException Se o valor da saturação for inválido.
     */
    public Saturacao(double saturacao) throws MedidaInvalidaException {
        super(saturacao);
        setSaturacao(saturacao);
    }

    /**
     * Cria uma instância de {@link Saturacao} a partir de um valor numérico.
     *
     * @param saturacao Valor da saturação de oxigénio.
     * @return Uma nova instância de {@link Saturacao}.
     */
    public static Medida fromDouble(double saturacao) throws MedidaInvalidaException {
        return new Saturacao(saturacao);
    }

    /**
     * Retorna o valor da saturação de oxigénio registada.
     *
     * @return Valor da saturação de oxigénio.
     */
    public double getSaturacao() {
        return saturacao;
    }

    /**
     * Define o valor da saturação de oxigénio registada.
     *
     * @param saturacao Valor da saturação de oxigénio.
     * @throws MedidaInvalidaException Se o valor da saturação for inválido.
     */
    public void setSaturacao(double saturacao) throws MedidaInvalidaException {
        if (saturacao < 50|| saturacao > 100) {
            throw new MedidaInvalidaException("Valor de saturação de oxigénio inválido.");
        }
        this.saturacao = saturacao;
    }

    /**
     * Retorna uma representação textual da medição saturação de oxigénio.
     *
     * @return Uma string contendo as informações da medição.
     */
    @Override
    public String toString() {
        return super.toString() + "\nSaturação de Oxigénio: " + saturacao;
    }
}
