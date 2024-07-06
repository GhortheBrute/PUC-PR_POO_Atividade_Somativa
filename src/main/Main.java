package src.main;

import src.modelo.Apartamento;
import src.modelo.Casa;
import src.modelo.Terreno;
import src.util.InterfaceUsuario;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//        List<Financiamento> listaFinanciamento = new ArrayList<>();
        InterfaceUsuario user1 = new InterfaceUsuario();

        // Inicia a operação de cadastro de investimento.
        user1.CadastrarInvestimento();

        // Cadastros automáticos para rapidez no código.
        var casa2 = new Casa(200000, 24, 14,86.4D,92D);
        var apartamento1 = new Apartamento(250000,24,16.8,1,3);
        var apartamento2 = new Apartamento(350000, 36, 12.4,2,4);
        var terreno1 = new Terreno(780000,72,17,"Residencial");
        var terreno2 = new Terreno(1080000,86,16.4,"Comercial");

        // Adiciona os investimentos através do método AddInvestimento de InterfaceUsuario
        user1.AddInvestimento(casa2);
        user1.AddInvestimento(apartamento1);
        user1.AddInvestimento(apartamento2);
        user1.AddInvestimento(terreno1);
        user1.AddInvestimento(terreno2);

        System.out.println("\n\n#### Exibir Investimento ####");
        user1.ExibirInvestimento();


    }
}