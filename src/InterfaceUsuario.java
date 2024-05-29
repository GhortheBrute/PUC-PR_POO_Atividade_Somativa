import java.text.NumberFormat;
import java.util.Scanner;

public class InterfaceUsuario {
    double valor;
    int prazo;
    double juros;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    public void DeclararValorImovel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInforme o valor do imóvel.");
        this.valor = scanner.nextDouble();
        System.out.println("Valor do Imóvel: " + formatter.format(this.valor));
    }

    public void DeclararPrazo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInforme o prazo total do financiamento.");
        this.prazo = scanner.nextInt();
        System.out.println("Prazo total de financiamento: " + prazo + " meses.");
    }

    public void DeclararJuros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInforme a taxa de juros.");
        this.juros = scanner.nextDouble();
        System.out.printf("Taxa de juros anual: %.2f%%%n",this.juros);
    }


}
