package com.healthtrack;

// import java.util.Scanner;

public class Teste {
  public static void main(String[] args) {
    printDados();
  }

  public static void printDados() {
    DadosDao dados = new DadosDao();

    Object[] registros = dados.getAll();

    for(int i = 0; i < registros.length; i++){
      System.out.println(registros[i]);
    }
  }

}
