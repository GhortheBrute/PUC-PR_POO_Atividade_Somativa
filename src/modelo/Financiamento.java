package src.modelo;

import java.io.Serializable;
import java.text.NumberFormat;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

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

    public double CalcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
    }

    public double CalcularTotalPagamento(){
        return CalcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public abstract String TipoDeInvestimento();
    public abstract String exportarTexto();
}