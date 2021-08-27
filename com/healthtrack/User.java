package com.healthtrack;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String nome;

    private String dataNasc;

    private String email;

    private String senha;

    private char genero;

    private List<RegistroDados> dadosRegistrados = new ArrayList<RegistroDados>();

    public User (String email, String senha) {
        this.email = email;
        this.senha = senha;

    }

    public void editDados (String dataNasc, String nome, char genero) {
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.genero = genero;
    }


    /**
     * Registra os novos dados inseridos pelo usuario
     * @param data
     * @param altura
     * @param peso
     */
    public void registrarNovosDados(String data, float altura, float peso) {
        RegistroDados novosDados = new RegistroDados(data, altura, peso);
        dadosRegistrados.add(novosDados);
    }

    public List<RegistroDados> getDadosRegistrados() {
        return dadosRegistrados;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

}