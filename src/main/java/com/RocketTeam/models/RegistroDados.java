package com.RocketTeam.models;
/**
 * Classe respons�vel por armazenar os dados de evolu��o f�sica do usu�rio
 */
public class RegistroDados {

    private String data;
    private float altura;
    private float peso;
    private float imc;

    public RegistroDados(String data, float altura, float peso) {
        this.data = data;
        this.altura = altura;
        this.peso = peso;
        this.imc = peso / (altura * altura);
    }


    
    /** 
     * Retorna a data em que o dado foi registrado
     * @return String
     */
    public String getData() {
        return data;
    }

    
    /** 
     * Retorna a altura
     * @return float
     */
    public float getAltura() {
        return altura;
    }

    
    /** 
     * Retorna o peso
     * @return float
     */
    public float getPeso() {
        return peso;
    }

    
    /** 
     * Retorna o calculo do IMC
     * @return float
     */
    public float getImc() {
        return imc;
    };

    
    /** 
     * Retorna o conjunto de todos os dados
     * @return String
     */
    @Override
    public String toString() {
        return ("Data: " + getData() + "\n" +
                "Altura: " + getAltura() + "\n" +
                "Peso: " + getPeso() + "\n" +
                "IMC: " + getImc() + "\n");
    }

}