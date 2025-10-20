package testes;

import java.util.Scanner;
import q6.*;

import java.util.InputMismatchException;

/**
 * Classe principal para testar as funcionalidades do banco de dados Iris e do algoritmo KNN.
 */

public class TesteIris {
	
    public static void main(String[] args) {
    	
        // O nome do arquivo é "iris.csv"
        String url = "iris.csv";
        DBIris db = null;
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Tenta carregar o banco de dados antes de iniciar o menu
        try {
            db = new DBIris(url);
            if (db.dataset == null) {
                // O construtor tratou o erro e setou o dataset como null.
            	System.out.println("Falha no carregamento. Verifique se o arquivo " + url + " " 
                + "existe e está no formato correto.");
            }
        } catch (Exception e) {
            System.err.println("Não foi possível carregar o banco de dados. Encerrando o programa.");
            System.err.println(e.getMessage());
            scanner.close();
            return;
        }

        do {
            System.out.println("\n===== Menu de Análise de Flores Iris =====");
            System.out.println("1. Imprimir todo o Dataset");
            System.out.println("2. Calcular e Imprimir Estatísticas Básicas");
            System.out.println("3. Classificar nova flor Iris usando KNN (k=1)");
            System.out.println("0. Sair\n");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {
                    case 1:
                        db.imprimir();
                        break;
                    case 2:
                        db.calcularEstatisticas();
                        break;
                    case 3:
                        System.out.println("\n--- Classificação KNN (k=1) ---");
                        
                        double comp_sepala = 0.0, lar_sepala = 0.0, comp_petala = 0.0, lar_pelata = 0.0;
                        boolean inputValido = false;
                        
                        while (!inputValido) {
                            try {
                                System.out.print("Informe o Comprimento da Sépala (cm): ");
                                comp_sepala = scanner.nextDouble();
                                System.out.print("Informe a Largura da Sépala (cm): ");
                                lar_sepala = scanner.nextDouble();
                                System.out.print("Informe o Comprimento da Pétala (cm): ");
                                comp_petala = scanner.nextDouble();
                                System.out.print("Informe a Largura da Pétala (cm): ");
                                lar_pelata = scanner.nextDouble();
                                inputValido = true;
                            } catch (InputMismatchException e) {
                                System.err.println("Entrada inválida. Por favor, insira apenas números decimais (ex: 4.9).");
                                scanner.nextLine(); // Limpa o buffer de entrada
                            }
                        }
                        
                        // Cria a nova instância com a classe a ser descoberta "?"
                        Iris novaIris = new Iris(comp_sepala, lar_sepala, comp_petala, lar_pelata, "?");
                        
                        // Classificação com k=1 (conforme sugestão)
                        int k = 1;
                        String classePredita = db.knn(novaIris, k);
                        
                        System.out.println("\nFlor de Entrada: " + novaIris.toString() + " (Classe: ?)");
                        System.out.println("A classe predita (KNN com k=" + k + ") é: " + classePredita);
                        break;
                    case 0:
                        System.out.println("Saindo do programa... Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, escolha uma opção do menu.");
                scanner.nextLine(); // Limpa o buffer de entrada
                opcao = -1; // Mantém o loop
            }
        } while (opcao != 0);

        scanner.close();
    }
}