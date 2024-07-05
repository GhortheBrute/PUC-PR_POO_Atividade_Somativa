package src.modelo;

import java.text.NumberFormat;

public class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

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
        this.taxaJurosAnual = taxaJurosAnual / 100;
    }

    public double CalcularPagamentoMensal(){
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
    }

    public double CalcularTotalPagamento(){
        return CalcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public String TipoDeInvestimento() {
        return "Financiamento";
    }
}