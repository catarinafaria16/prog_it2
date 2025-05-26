package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;

/**
 * Representa uma medição de temperatura de um paciente, estendendo a classe {@link Medida}.
 */
public class Temperatura extends Medida {

    /**
     * Valor da temperatura registada.
     */
    private double temperatura;

    /**
     * Constrói uma instância de {@link Temperatura}.
     *
     * @param dataRegisto       Data da medição.
     * @param paciente          Paciente associado.
     * @param profissionalSaude Profissional de saúde responsável pela medição.
     * @param temperatura       Valor da temperatura.
     * @throws MedidaInvalidaException Se o valor da temperatura for inválido.
     */
    public Temperatura(Data dataRegisto, Paciente paciente, ProfissionalSaude profissionalSaude, double temperatura) throws MedidaInvalidaException {
        super(dataRegisto, paciente, profissionalSaude);
        setTemperatura(temperatura);
    }

    /**
     * Constrói uma instância de {@link Temperatura} com apenas o valor da temperatura.
     *
     * @param temperatura Valor da temperatura.
     * @throws MedidaInvalidaException Se o valor da temperatura for inválido.
     */
    public Temperatura (double temperatura) throws MedidaInvalidaException {
        super(temperatura);
        if (temperatura <= 0) {
            throw new IllegalArgumentException("Temperatura inválida.");
        }
        setTemperatura(temperatura);
    }

    /**
     * Cria uma instância de {@link Temperatura} a partir de um valor numérico.
     *
     * @param temperatura Valor da temperatura.
     * @return Uma nova instância de {@link Temperatura}.
     */
    public static Medida fromDouble(double temperatura) throws MedidaInvalidaException {
        return new Temperatura(temperatura);
    }

    /**
     * Retorna o valor da temperatura registada.
     *
     * @return Valor da temperatura.
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Define o valor da temperatura registada.
     *
     * @param temperatura Valor da temperatura.
     * @throws MedidaInvalidaException Se o valor da temperatura for inválido.
     */
    public void setTemperatura(double temperatura) throws MedidaInvalidaException {
        if (temperatura < 25 || temperatura > 45) {
            throw new MedidaInvalidaException("Valor de temperatura inválido.");
        }
        this.temperatura = temperatura;
    }

    /**
     * Retorna uma representação textual da medição temperatura.
     *
     * @return Uma string contendo as informações da medição.
     */
    @Override
    public String toString() {
        return super.toString() + "\nTemperatura: " + temperatura;
    }
}
