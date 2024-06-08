package util;

import modelo.Financiamento;

import java.text.NumberFormat;
import java.util.Scanner;

public class InterfaceUsuario {
    double valor;
    int prazo;
    double juros;
    Financiamento financiamento;

    Scanner scanner = new Scanner(System.in);
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
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
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Por favor tente novamente.");
            }
        }
    }

    public void DeclararPrazo(){
        while (true) {
            try {
                System.out.println("\nInforme o prazo total do financiamento.");
                this.prazo = scanner.nextInt();
                if (this.prazo <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Prazo total de financiamento: " + prazo + " meses.");
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Por favor tente novamente.");
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
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Por favor tente novamente.");
            }
        }
    }

    public void CadastrarInvestimento(){
        DeclararValorImovel();
        DeclararPrazo();
        DeclararJuros();
        financiamento = new Financiamento(this.valor,this.prazo, this.juros);
    }

    public void ExibirInvestimento(){
        financiamento.ExibeDadosDoFinanciamento();
    }

}