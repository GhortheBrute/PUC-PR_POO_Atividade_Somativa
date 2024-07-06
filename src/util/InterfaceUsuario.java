package src.util;

import src.modelo.Casa;
import src.modelo.Financiamento;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private double valor;
    private int prazo;
    private double juros;
    private double areaConstruida;
    private double tamanhoTerreno;
    List<Financiamento> financiamentos;
    Scanner scanner = new Scanner(System.in);
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public InterfaceUsuario() {
        this.financiamentos = new ArrayList<>();
    }
    public void DeclararValorImovel(){
        while (true) {
            try {
                System.out.println("\nInforme o valor do imóvel.");
                this.valor = scanner.nextDouble();
                if (this.valor <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else{
                    System.out.println("Valor do Imóvel: " + formatter.format(this.valor));
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    public void DeclararPrazo(){
        while (true) {
            try {
                System.out.println("\nInforme o prazo total do proposta, em meses.");
                this.prazo = scanner.nextInt();
                if (this.prazo <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Prazo total de proposta: " + prazo + " meses.");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    public void DeclararJuros(){
        while (true) {
            try {
                System.out.println("\nInforme a taxa de juros.");
                this.juros = scanner.nextDouble();
                if (this.juros <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.printf("Taxa de juros anual: %.2f%%%n\n", this.juros);
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    public void DeclararAreaConstruida(){
        while (true) {
            try {
                System.out.println("\nInforme o total da área construída, em m².");
                this.areaConstruida = scanner.nextDouble();
                if (this.areaConstruida <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Total de Área Construída: " + this.areaConstruida + "m².");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    public void DeclararTamanhoTerreno(){
        while (true) {
            try {
                System.out.println("\nInforme o tamanho do terreno, em m².");
                this.tamanhoTerreno = scanner.nextDouble();
                if (this.tamanhoTerreno <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Tamanho do terreno: " + this.tamanhoTerreno + "m².");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }
    public void CadastrarInvestimento(){
        DeclararValorImovel();
        DeclararPrazo();
        DeclararJuros();
        DeclararAreaConstruida();
        DeclararTamanhoTerreno();
        Financiamento proposta = new Casa(this.valor,this.prazo, this.juros, this.areaConstruida, this.tamanhoTerreno);
        financiamentos.add(proposta);
    }

    public void AddInvestimento(Financiamento proposta){
        financiamentos.add(proposta);
    }

    public void ExibirInvestimento(){
        double totalImoveis = 0;
        double totalFinanciamento = 0;
        double valorImovel;
        double valorMensalidade;
        double valorTotal;
        int i = 0;

        for (var fin : financiamentos){
            valorImovel = fin.getValorImovel();
            valorMensalidade = fin.CalcularPagamentoMensal();
            valorTotal = fin.CalcularTotalPagamento();

            i++;
            totalImoveis += valorImovel;
            totalFinanciamento += valorTotal;

            System.out.printf("Financiamento %d - %s - Valor do Imóvel: %s, Valor do Financiamento: %s, Valor da Parcela: %s\n\n"
                    ,i
                    ,fin.TipoDeInvestimento()
                    ,formatter.format(valorImovel)
                    ,formatter.format(valorTotal)
                    ,formatter.format(valorMensalidade));
        }
        System.out.printf("Total de todos os imóveis: %s, totalFinanciamento de todos os financiamentos: %s."
                ,formatter.format(totalImoveis)
                ,formatter.format(totalFinanciamento));
    }

}