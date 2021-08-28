package com.healthtrack;

public abstract class Pessoa {
    private char genero;
    private String dataNasc;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void editDados (String dataNasc, String nome, char genero) {
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.genero = genero;
    }
}
