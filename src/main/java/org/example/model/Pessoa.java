package org.example.model;

import org.example.utils.Data;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String sexo;
    protected Data dataNascimento;

    public Pessoa(int id, String nome, String sexo, Data dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = new Data(dataNascimento);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String Sexo) {
        this.sexo = sexo;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("ID:").append(id).append(" ");;
        sb.append(", NOME:").append(nome).append(" ");
        sb.append(", SEXO: ").append(sexo).append(" ");;
        sb.append(", DATA DE NASCIMENTO: ").append(dataNascimento).append(" ");;
        return sb.toString();
    }
}
