package main;

import util.InterfaceUsuario;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        InterfaceUsuario user1 = new InterfaceUsuario();

        user1.CadastrarInvestimento();

        user1.ExibirInvestimento();
    }
}