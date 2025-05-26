package org.example.model;

import org.example.interfaces.IPessoa;
import org.example.utils.Data;

/**
 * Classe abstrata que representa uma pessoa, implementando a interface {@link IPessoa}.
 * Inclui atributos comuns como ID, nome, sexo e data de nascimento.
 */
public abstract class Pessoa implements IPessoa {
    /**
     * Identificador único da pessoa.
     */
    protected int id;

    /**
     * Nome da pessoa.
     */
    protected String nome;

    /**
     * Sexo da pessoa.
     */
    protected String sexo;

    /**
     * Data de nascimento da pessoa.
     */
    protected Data dataNascimento;

    /**
     * Constrói uma nova instância de {@link Pessoa}.
     *
     * @param id             Identificador único da pessoa.
     * @param nome           Nome da pessoa.
     * @param sexo           Sexo da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     */
    public Pessoa(int id, String nome, String sexo, Data dataNascimento) {
        setId(id);
        setNome(nome);
        setSexo(sexo);
        setDataNascimento(dataNascimento);
    }

    /**
     * Retorna o código identificador único da pessoa.
     *
     * @return ID da pessoa.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Define o código identificador único da pessoa.
     *
     * @param id Novo ID da pessoa.
     * @throws IllegalArgumentException Se o ID for menor ou igual a zero.
     */
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
        this.id = id;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome Novo nome da pessoa.
     * @throws IllegalArgumentException Se o nome for nulo ou vazio.
     */
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna o sexo da pessoa.
     *
     * @return Sexo da pessoa.
     */
    @Override
    public String getSexo() {
        return sexo;
    }

    /**
     * Define o sexo da pessoa.
     *
     * @param sexo Novo sexo da pessoa.
     * @throws IllegalArgumentException Se o sexo for nulo ou vazio.
     */
    public void setSexo(String sexo) {
        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException("O sexo não pode ser nulo ou vazio.");
        }
        this.sexo = sexo;
    }

    /**
     * Retorna a data de nascimento da pessoa.
     *
     * @return Data de nascimento da pessoa.
     */
    @Override
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataNascimento Nova data de nascimento.
     * @throws IllegalArgumentException Se a data de nascimento for nula.
     */
    public void setDataNascimento(Data dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("A data de nascimento não pode ser nula.");
        }
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna uma representação textual da pessoa.
     *
     * @return String representando os atributos da pessoa.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("ID:").append(id).append(" ");
        ;
        sb.append(", NOME:").append(nome).append(" ");
        sb.append(", SEXO: ").append(sexo).append(" ");
        ;
        sb.append(", DATA DE NASCIMENTO: ").append(dataNascimento).append(" ");
        ;
        return sb.toString();
    }
}
