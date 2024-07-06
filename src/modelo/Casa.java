package src.modelo;

import src.util.DescontoMaiorDoQueJurosException;

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

    private void ValidaDesconto(double valorDesconto, double pagamentoMensal) throws DescontoMaiorDoQueJurosException {
        if (valorDesconto > pagamentoMensal){
            throw new DescontoMaiorDoQueJurosException("Desconto superior ao permitido.");
        }
    }
    @Override
    public double CalcularPagamentoMensal(){
        try {
            ValidaDesconto(0,super.CalcularPagamentoMensal());
        }catch (DescontoMaiorDoQueJurosException e){
            e.getMessage();
        }
        return super.CalcularPagamentoMensal() + seguro;
    }


    public String TipoDeInvestimento() {
        return "Casa";
    }
}