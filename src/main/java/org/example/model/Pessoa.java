package org.example.model;

import org.example.utils.Data;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected char sexo;
    protected Data dataNascimento;

    public Pessoa(int id, String nome, char sexo, Data dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = new Data(dataNascimento);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + '}';
    }
}
