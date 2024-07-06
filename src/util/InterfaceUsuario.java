package src.util;

import src.modelo.Casa;
import src.modelo.Financiamento;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private double valor;
    private int prazo;
    private double juros;
    private double areaConstruida;
    private double tamanhoTerreno;
    List<Financiamento> financiamentos;
    Scanner scanner = new Scanner(System.in);
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public InterfaceUsuario() {
        this.financiamentos = new ArrayList<>();
    }

    // Método para declarar o valor do imóvel, com checagem de valores indevidos.
    public void DeclararValorImovel(){
        while (true) {
            try {
                System.out.println("\nInforme o valor do imóvel.");
                this.valor = scanner.nextDouble();
                if (this.valor <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else{
                    System.out.println("Valor do Imóvel: " + formatter.format(this.valor));
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    // Método para declarar o prazo de investimento do imóvel, com checagem de valores indevidos.
    public void DeclararPrazo(){
        while (true) {
            try {
                System.out.println("\nInforme o prazo total do proposta, em meses.");
                this.prazo = scanner.nextInt();
                if (this.prazo <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Prazo total de proposta: " + prazo + " meses.");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    // Método para declarar o valor de juros do investimento, com checagem de valores indevidos.
    public void DeclararJuros(){
        while (true) {
            try {
                System.out.println("\nInforme a taxa de juros.");
                this.juros = scanner.nextDouble();
                if (this.juros <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.printf("Taxa de juros anual: %.2f%%%n\n", this.juros);
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    // Método para declarar a área construída do imóvel, com checagem de valores indevidos.
    public void DeclararAreaConstruida(){
        while (true) {
            try {
                System.out.println("\nInforme o total da área construída, em m².");
                this.areaConstruida = scanner.nextDouble();
                if (this.areaConstruida <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Total de Área Construída: " + this.areaConstruida + "m².");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    // Método para declarar o terreno do imóvel, com checagem de valores indevidos.
    public void DeclararTamanhoTerreno(){
        while (true) {
            try {
                System.out.println("\nInforme o tamanho do terreno, em m².");
                this.tamanhoTerreno = scanner.nextDouble();
                if (this.tamanhoTerreno <= 0){
                    System.out.println("Valor inválido. Por favor informe um valor positivo.");
                }else {
                    System.out.println("Tamanho do terreno: " + this.tamanhoTerreno + "m².");
                    break;
                }
            }catch (Exception e){
                System.out.println("Valor inválido. Por favor tente novamente.");
                scanner.nextLine();
            }
        }
    }

    // Método de obter todas as informações do investimento e construir o objeto corretamente.
    public void CadastrarInvestimento(){
        DeclararValorImovel();
        DeclararPrazo();
        DeclararJuros();
        DeclararAreaConstruida();
        DeclararTamanhoTerreno();
        Financiamento proposta = new Casa(this.valor,this.prazo, this.juros, this.areaConstruida, this.tamanhoTerreno);
        financiamentos.add(proposta);
    }

    // Método de adicionar novos investimentos ao arraylist.
    public void AddInvestimento(Financiamento proposta){
        financiamentos.add(proposta);
    }

    // Método de exibir os investimentos, gravar os dados em um arquivo .txt e o objeto arraylist num arquivo .dat
    public void ExibirInvestimento(){
        double totalImoveis = 0;
        double totalFinanciamento = 0;
        double valorImovel;
        double valorMensalidade;
        double valorTotal;
        int i = 0;
        StringBuilder texto = new StringBuilder();
        String textoFinal = null;

        for (var fin : financiamentos){
            valorImovel = fin.getValorImovel();
            valorMensalidade = fin.CalcularPagamentoMensal();
            valorTotal = fin.CalcularTotalPagamento();
            texto.append(fin.exportarTexto());
            texto.append("\n\n");

            i++;
            totalImoveis += valorImovel;
            totalFinanciamento += valorTotal;

            System.out.printf("Financiamento %d - %s - Valor do Imóvel: %s, Valor do Financiamento: %s, Valor da Parcela: %s\n\n"
                    ,i
                    ,fin.TipoDeInvestimento()
                    ,formatter.format(valorImovel)
                    ,formatter.format(valorTotal)
                    ,formatter.format(valorMensalidade));
        }
        System.out.printf("Total de todos os imóveis: %s, totalFinanciamento de todos os financiamentos: %s."
                ,formatter.format(totalImoveis)
                ,formatter.format(totalFinanciamento));
        textoFinal = texto.substring(0, texto.length() - 1);
        System.out.println("\n\n#### Escrever Dados ####\n");
        escreveDados("Financiamentos.txt",textoFinal);
        System.out.println("\n#### Lendo Dados ####");
        lerDados("Financiamentos.txt");
        System.out.println("\n\n#### Escrevendo Objeto ####");
        escreveObjetos("Financiamentos.dat",financiamentos);
        System.out.println("\n#### Lendo Objeto ####");
        lerObjetos("Financiamentos.dat");
    }

    // Método de escrever dados num arquivo .txt enquanto imprime o que foi escrito, para comparação.
    public static void escreveDados (String filename, String texto) {
        FileWriter out = null;
        int letras = 0;
        try {
            out = new FileWriter(filename);
            while (letras < texto.length()) {
                out.write(texto.charAt(letras));
                System.out.printf(String.valueOf(texto.charAt(letras)));
                letras++;
            }

            out.flush();
            out.close();
//        ObjectOutputStream outputStream = null;
//        try{
//            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
//
//            outputStream.flush();
//            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método de ler dados num arquivo .txt e imprimir o resultado, para comparação.
    public static void lerDados (String filename){
        FileReader in = null;
        try{
            in = new FileReader(filename);
            int c;
            while ((c = in.read()) != -1)
                System.out.print((char)c);
            in.close();
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método de escrever um objeto arraylist num arquivo .dat
    public static void escreveObjetos (String filename, Object obj){
        ObjectOutputStream outputStream = null;
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(obj);
            outputStream.flush();
            outputStream.close();
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Método de ler um objeto arraylist num arquivo .dat e imprime para verificação.
    public static void lerObjetos (String filename){
        ObjectInputStream inputStream;
        Object obj;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            ArrayList<Financiamento> finan = (ArrayList<Financiamento>) inputStream.readObject();
            for (Financiamento f : finan)
                System.out.println(f.exportarTexto());
            inputStream.close();
        }catch (EOFException e) {
            System.out.println("Fim do arquivo.");
        }catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada.");
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}