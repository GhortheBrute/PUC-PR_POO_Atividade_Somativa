package src.modelo;

public class Terreno extends Financiamento{
    private String zona;
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    @Override
    public double CalcularPagamentoMensal(){
        return super.CalcularPagamentoMensal() * 1.02;
    }

    @Override
    public String TipoDeInvestimento() {
        return "Terreno";
    }

    @Override
    public String exportarTexto() {
        return "Financiamento - " + TipoDeInvestimento() + " - Valor do Imóvel: " + formatter.format(getValorImovel()) +
                ", Valor do Financiamento: " + formatter.format(CalcularTotalPagamento()) + ", Valor da parcela: " + formatter.format(CalcularPagamentoMensal()) +
                ". Tipo de Zona: " + getZona() + ".";
    }
}
