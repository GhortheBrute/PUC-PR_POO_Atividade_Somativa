package modelo;

import java.text.NumberFormat;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double CalcularPagamentoMensal(){
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
    }

    public double CalcularTotalPagamento(){
        return CalcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public void ExibeDadosDoFinanciamento(){
        NumberFormat f = NumberFormat.getCurrencyInstance();
        System.out.println("Dados do Financiamento:");
        System.out.printf("Valor total do financiamento: %s\nValor do Imóvel: %s", f.format(CalcularTotalPagamento()), f.format(this.valorImovel));
    }
}