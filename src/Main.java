import java.text.NumberFormat;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        InterfaceUsuario user1 = new InterfaceUsuario();

        user1.DeclararValorImovel();
        user1.DeclararPrazo();
        user1.DeclararJuros();

        Financiamento financiamento = new Financiamento(user1.valor,user1.prazo, user1.juros);

        System.out.printf("Valor total do financiamento: R$ %s\n" +
                "Valor das mensalidades: R$ %s", formatter.format(financiamento.CalcularTotalPagamento()), formatter.format(financiamento.CalcularPagamentoMensal()));

    }
}
