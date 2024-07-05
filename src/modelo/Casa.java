package src.modelo;

public class Casa extends Financiamento {
    private final double seguro = 80.00;
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
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