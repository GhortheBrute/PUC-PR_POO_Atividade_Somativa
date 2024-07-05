package src.modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double CalcularPagamentoMensal() {
        return super.CalcularPagamentoMensal() * 1.02;
    }

    @Override
    public String TipoDeInvestimento() {
        return "Terreno";
    }
}
