public class Financiamento {
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

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
}
