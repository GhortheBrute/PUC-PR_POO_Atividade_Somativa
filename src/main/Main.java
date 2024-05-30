package main;

import modelo.Financiamento;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//
//        InterfaceUsuario user1 = new InterfaceUsuario();
//
//        user1.CadastrarInvestimento();
//
//        user1.ExibirInvestimento();
        List<Financiamento> listaFinanciamento = new ArrayList<>();

        Financiamento financiamento1 = new Financiamento(200000,24,14);
        Financiamento financiamento2 = new Financiamento(250000,24,16.8);
        Financiamento financiamento3 = new Financiamento(350000,36,12.4);
        Financiamento financiamento4 = new Financiamento(780000,72,17);

        listaFinanciamento.add(financiamento1);
        listaFinanciamento.add(financiamento2);
        listaFinanciamento.add(financiamento3);
        listaFinanciamento.add(financiamento4);

        for (int i = 0; i < listaFinanciamento.size(); i++) {
            System.out.printf("Financiamento %d - Valor do Imóvel: %s, Valor do Financiamento: %s.\n\n"
                    ,i +1
                    ,formatter.format(listaFinanciamento.get(i).getValorImovel())
                    ,formatter.format(listaFinanciamento.get(i).CalcularTotalPagamento()));
        }

        double totalImoveis = 0;
        double totalFinanciamento = 0;
        for (Financiamento fin : listaFinanciamento){
            totalImoveis += fin.getValorImovel();
            totalFinanciamento += fin.CalcularTotalPagamento();
        }
        System.out.printf("Total de todos os imóveis: %s, totalFinanciamento de todos os financiamentos: %s."
                ,formatter.format(totalImoveis)
                ,formatter.format(totalFinanciamento));
    }
}