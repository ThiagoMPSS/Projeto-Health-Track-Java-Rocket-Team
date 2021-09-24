package com.healthtrack;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Classe de inicialização da aplicação
 */
public class Program {
    static User user = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        criarUsuario(scanner);
        exibirMenuPrinc(scanner);

        // scanner.close();
    }

    private static void exibirMenuPrinc(Scanner scanner) {
        int escolha = 0;

        while (true) {
            escolha = 0;
            System.out.println("***************************");
            System.out.println("1 - Informar dados pessoais");
            System.out.println("2 - Registrar novos dados");
            System.out.println("3 - Recuperar dados");
            System.out.println("***************************");

            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                informarDados(scanner);
                // break;
            } else if (escolha == 2) {
                registarNovoDado(scanner);
                // break;
            } else if (escolha == 3) {
                exibirDados(0);
                // break;
            }
        }
    }
    
    private static void criarUsuario(Scanner scanner) {
        System.out.println("Sem usuario cadastro, cadastre um agora:\n");
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        user = new User(email, senha);
    }

    private static void informarDados(Scanner scanner) {
        System.out.print("Digite a sua data de Nascimento: ");
        String dtNasc = scanner.nextLine();
        System.out.print("Digite o seu Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu gênero(F/M): ");
        char gÃªnero = scanner.nextLine().charAt(0);

        user.editDados(dtNasc, nome, gÃªnero);
    }

    private static void registarNovoDado(Scanner scanner) {
        System.out.print("Digite seu peso atual: ");
        float peso = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite sua altura atual: ");
        float altura = scanner.nextFloat();
        scanner.nextLine();

        GregorianCalendar data = new GregorianCalendar();
        String dataString = data.get(GregorianCalendar.DAY_OF_MONTH) + "/" + data.get(GregorianCalendar.MONTH) + "/" + data.get(GregorianCalendar.YEAR);

        user.registrarNovosDados(dataString, altura, peso);
    }

    private static void exibirDados(int index) {
        if (user.getDadosRegistrados().length == 0){
            System.out.println("Nenhum dado registrado até o momento!\n");
            return;
        }

        System.out.println(user.getDadosRegistrados()[index]);
        if (user.getDadosRegistrados().length - 1 > index) {
            exibirDados(index + 1);
        }
    }

}