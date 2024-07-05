package src.main;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");

        int numero = scanner.nextInt();

        if (numero % 2 != 0) {

            System.out.println(numero + " é um número primo.");

        } else {
            System.out.println(numero + " não é um número primo.");

        }
        scanner.close();
    }

    // Função para verificar se o número é primo

//    public static boolean ehPrimo(int numero) {
//        if (numero <= 1) return false;
//        for (int i = 2; i <= Math.sqrt(numero); i++) {
//            if (numero % i == 0) return false;
//            return true;
//        }
//    }
}

