package com.healthtrack;

/**
 * Classe abstrata responsável por armazenar dados pessoais
 */
public abstract class Pessoa {
    private char genero;
    private String dataNasc;
    private String nome;
    
    public Pessoa() {}

    /** 
     * Retorna o Nome
     * @return String
     */
    public String getNome() {
        return nome;
    }
    
    /** 
     * Define o nome da pessoa
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /** 
     * Retorna a data de Nascimento
     * @return String
     */
    public String getDataNasc() {
        return dataNasc;
    }

    
    /** 
     * Define a data de Nascimento
     * @param dataNasc
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    /** 
     * Retorna o Gênero
     * @return char
     */
    public char getGenero() {
        return genero;
    }
    
    /** 
     * Define o Gênero
     * @param genero
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    /** 
     * Edita todos os dados Pessoais
     * @param dataNasc
     * @param nome
     * @param genero
     */
    public void editDados (String dataNasc, String nome, char genero) {
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.genero = genero;
    }
}
