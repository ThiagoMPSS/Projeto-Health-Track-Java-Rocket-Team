package com.healthtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe respons�vel por armazenar os dados do usu�rio
 */
public class User extends Pessoa {
    private String email;

    // private String senha; //

    private List<RegistroDados> dadosRegistrados = new ArrayList<RegistroDados>();

    public User (String email, String senha) {
        this.email = email;
    //    this.senha = senha; //

    }

    /**
     * Registra os novos dados inseridos pelo usu�rio
     * @param data
     * @param altura
     * @param peso
     */
    public void registrarNovosDados(String data, float altura, float peso) {
        RegistroDados novosDados = new RegistroDados(data, altura, peso);
        dadosRegistrados.add(novosDados);
    }

    
    /** 
     * Retorna a Array com os dados registrados at� o momento
     * @return RegistroDados[]
     */
    public RegistroDados[] getDadosRegistrados() {
        RegistroDados[] dadosArray = new RegistroDados[dadosRegistrados.size()];
        dadosRegistrados.toArray(dadosArray);
        return dadosArray;
    }

    
    /** 
     * Retorna o Email cadastrado
     * @return String
     */
    public String getEmail() {
        return email;
    }

}