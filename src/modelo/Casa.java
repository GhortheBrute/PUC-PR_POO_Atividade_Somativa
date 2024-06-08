package src.modelo;

public class Casa extends Financiamento {
    private final double seguro = 80.00;
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double CalcularPagamentoMensal() {
        return super.CalcularPagamentoMensal() + seguro;
    }

    @Override
    public String TipoDeInvestimento() {
        return "Casa";
    }
}