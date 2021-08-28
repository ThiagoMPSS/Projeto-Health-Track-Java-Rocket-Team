package com.healthtrack;

import java.util.ArrayList;
import java.util.List;

public class User extends Pessoa {
    private String email;

    private String senha;

    private List<RegistroDados> dadosRegistrados = new ArrayList<RegistroDados>();

    public User (String email, String senha) {
        this.email = email;
        this.senha = senha;

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

    public RegistroDados[] getDadosRegistrados() {
        RegistroDados[] dadosArray = new RegistroDados[dadosRegistrados.size()];
        dadosRegistrados.toArray(dadosArray);
        return dadosArray;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}