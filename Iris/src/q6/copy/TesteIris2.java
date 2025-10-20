package q6.copy;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import q6.*;

public class TesteIris2 {
    private static final String IRIS_CSV_URL = "https://gist.githubusercontent.com/curran/a08a1080b88344b0c8a7/raw/0e7a9b0a5d22642a06d3d5b9bcbad9890c8ee534/iris.csv";
    private static final String LOCAL_CSV_PATH = "iris.csv";

    public static void main(String[] args) {
        // 1. Baixar o arquivo iris.csv
        System.out.println("Baixando iris.csv...");
        
        try {
            downloadFile(IRIS_CSV_URL, LOCAL_CSV_PATH);
            System.out.println("iris.csv baixado com sucesso para " + LOCAL_CSV_PATH);
        } catch (IOException e) {
            System.err.println("Erro ao baixar o arquivo iris.csv: " + e.getMessage());
            return;
        }

        DBIris db = null;
        try {
            // 2. Criar instância de DBIris
            db = new DBIris(LOCAL_CSV_PATH);

            // 3. Imprimir o dataset
            db.imprimir();

            // 4. Calcular e imprimir estatísticas
            db.calcularEstatisticas();

            // 5. Testar o método knn
            System.out.println("\n--- Testando KNN ---");
            // Exemplo de uso: Iris com tipo desconhecido
            Iris novaIris = new Iris(4.9, 3.1, 1.5, 0.4, "?");
            String classePrevista = db.knn(novaIris, 1);
            System.out.println("A classe prevista para a nova Iris " + novaIris + " é: " + classePrevista);

            // Menu amigável de opções (simplificado para demonstração)
            Scanner scanner = new Scanner(System.in);
            int opcao = -1;
            
            while (opcao != 0) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Imprimir Dataset");
                System.out.println("2. Calcular Estatísticas");
                System.out.println("3. Testar KNN com nova Iris");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                
                try {
                    opcao = Integer.parseInt(scanner.nextLine());

                    switch (opcao) {
                        case 1:
                            db.imprimir();
                            break;
                        case 2:
                            db.calcularEstatisticas();
                            break;
                        case 3:
                            System.out.print("Digite Comprimento Sepala: ");
                            double cs = Double.parseDouble(scanner.nextLine());
                            System.out.print("Digite Largura Sepala: ");
                            double ls = Double.parseDouble(scanner.nextLine());
                            System.out.print("Digite Comprimento Petala: ");
                            double cp = Double.parseDouble(scanner.nextLine());
                            System.out.print("Digite Largura Petala: ");
                            double lp = Double.parseDouble(scanner.nextLine());
                            Iris customIris = new Iris(cs, ls, cp, lp, "?");
                            System.out.print("Digite o valor de K para KNN: ");
                            int k = Integer.parseInt(scanner.nextLine());
                            String customClasse = db.knn(customIris, k);
                            System.out.println("A classe prevista para " + customIris + " é: " + customClasse);
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Entrada inválida. Por favor, digite um número.");
                } catch (Exception e) {
                    System.err.println("Ocorreu um erro: " + e.getMessage());
                }
            }
            scanner.close();

        } catch (Exception e) {
            System.err.println("Ocorreu um erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Limpeza: remover o arquivo CSV baixado
            try {
                Files.deleteIfExists(Paths.get(LOCAL_CSV_PATH));
                System.out.println("Arquivo temporário " + LOCAL_CSV_PATH + " removido.");
            } catch (IOException e) {
                System.err.println("Erro ao remover o arquivo temporário: " + e.getMessage());
            }
        }
    }

    private static void downloadFile(String fileURL, String localPath) throws IOException {
        URL url = new URL(fileURL);
        try (java.io.InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(localPath), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}