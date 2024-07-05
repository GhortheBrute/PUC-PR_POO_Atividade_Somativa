package src.modelo;

public class Apartamento extends Financiamento {
    @SuppressWarnings("CanBeFinal")
    private double taxaJurosMensal;
    @SuppressWarnings("CanBeFinal")
    private int meses;
    private int vagasGaragem;
    private int andar;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaJurosMensal = (taxaJurosAnual / 100) / 12;
        this.meses = prazoFinanciamento * 12;
        this.vagasGaragem = vagasGaragem;
        this.andar = andar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getAndar() {
        return andar;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public double CalcularPagamentoMensal() {
        return (this.getValorImovel() * (Math.pow((1 + this.getTaxaJurosMensal()), this.getMeses()))) / (Math.pow((1 + (this.getTaxaJurosMensal())), (this.getMeses() - 1))) / this.getMeses();
    }

    @Override
    public double CalcularTotalPagamento() {
        return CalcularPagamentoMensal() * this.getMeses();
    }

    @Override
    public String TipoDeInvestimento() {
        return "Apartamento";
    }
}
