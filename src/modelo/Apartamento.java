package src.modelo;

public class Apartamento extends Financiamento {
    private double taxaJurosMensal;
    private int meses;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaJurosMensal = (taxaJurosAnual / 100) / 12;
        this.meses = prazoFinanciamento * 12;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public double CalcularPagamentoMensal() {
//        var result = (this.getValorImovel() * (Math.pow((1 + this.getTaxaJurosMensal()), this.getMeses()))) / (Math.pow((1 + (this.getTaxaJurosMensal())), (this.getMeses() - 1)));
//        System.out.println("Mensalidade: " + result);
//        return result;
        return (this.getValorImovel() * (Math.pow((1 + this.getTaxaJurosMensal()), this.getMeses()))) / (Math.pow((1 + (this.getTaxaJurosMensal())), (this.getMeses() - 1))) / this.getMeses();
    }

    @Override
    public double CalcularTotalPagamento() {
//        var result = CalcularPagamentoMensal() * this.getMeses();
//        System.out.println("Total Pagamento: " + result);
//        return result;
        return CalcularPagamentoMensal() * this.getMeses();
    }

    @Override
    public String TipoDeInvestimento() {
        return "Apartamento";
    }

    //    public static void main(String[] args) {
//        double imv = 350000;
//        double txMensal = 0.0103333333333333;
//        int meses = 432;
//
//        var resultado = (imv * (Math.pow((1+ txMensal),meses))) / (Math.pow((1 + txMensal), meses - 1));
//        var exemplo = (500000 * Math.pow((1 + (0.10 / 12)),(10 * 12))) / (Math.pow((1 + (0.10 / 12)),((10 * 12) - 1)));
//        System.out.println("Mensalidade: " + resultado);
//        System.out.println("Exemplo: " + exemplo);
//        System.out.println(Math.pow(2,3));
//    }
}
