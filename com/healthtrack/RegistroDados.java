package com.healthtrack;

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

    public String getData() {
        return data;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public float getImc() {
        return imc;
    };

    @Override
    public String toString() {
        return ("Data: " + getData() + "\n" +
                "Altura: " + getAltura() + "\n" +
                "Peso: " + getPeso() + "\n" +
                "IMC: " + getImc() + "\n");
    }

}