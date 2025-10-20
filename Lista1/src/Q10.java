import java.util.Scanner;
import java.util.ArrayList; // Para usar ArrayList como "lista de listas"
import java.text.DecimalFormat; // Para formatar a saída de doubles

public class Q10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        ArrayList<ArrayList<Double>> matrizA = null; // Inicializa como null
        ArrayList<ArrayList<Double>> matrizB = null; // Inicializa como null

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Criar Matriz A
                    System.out.println("\n--- Criar Matriz A ---");
                    matrizA = criarMatriz(scanner);
                    if (matrizA != null) {
                        System.out.println("Matriz A criada:");
                        imprimirMatriz(matrizA);
                    }
                    break;
                case 2: // Criar Matriz B
                    System.out.println("\n--- Criar Matriz B ---");
                    matrizB = criarMatriz(scanner);
                    if (matrizB != null) {
                        System.out.println("Matriz B criada:");
                        imprimirMatriz(matrizB);
                    }
                    break;
                case 3: // Somar Matrizes
                    System.out.println("\n--- Somar Matrizes A + B ---");
                    if (matrizA == null || matrizB == null) {
                        System.out.println("Erro: Ambas as matrizes A e B devem ser criadas primeiro.");
                    } else {
                        ArrayList<ArrayList<Double>> matrizSoma = somarMatrizes(matrizA, matrizB);
                        if (matrizSoma != null) {
                            System.out.println("Resultado da Soma (Matriz C):");
                            imprimirMatriz(matrizSoma);
                        }
                    }
                    break;
                case 4: // Multiplicar Matriz por Escalar
                    System.out.println("\n--- Multiplicar Matriz por Escalar ---");
                    if (matrizA == null) {
                        System.out.println("Erro: A Matriz A deve ser criada primeiro.");
                    } else {
                        System.out.print("Digite o valor escalar (k): ");
                        double k = scanner.nextDouble();
                        ArrayList<ArrayList<Double>> matrizMultiplicada = multiplicarPorEscalar(matrizA, k);
                        System.out.println("Resultado da Multiplicação por Escalar (Matriz A * " + df.format(k) + "):");
                        imprimirMatriz(matrizMultiplicada);
                    }
                    break;
                case 5: // Multiplicação de Matrizes
                    System.out.println("\n--- Multiplicação de Matrizes A x B ---");
                    if (matrizA == null || matrizB == null) {
                        System.out.println("Erro: Ambas as matrizes A e B devem ser criadas primeiro.");
                    } else {
                        ArrayList<ArrayList<Double>> matrizProduto = multiplicarMatrizes(matrizA, matrizB);
                        if (matrizProduto != null) {
                            System.out.println("Resultado da Multiplicação (Matriz C):");
                            imprimirMatriz(matrizProduto);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
            System.out.println(); // Linha em branco para melhor legibilidade
        } while (opcao != 0);

        scanner.close();
    }

    // --- Métodos Auxiliares e Funcionalidades ---

    public static void exibirMenu() {
        System.out.println("--- Operações entre Matrizes ---");
        System.out.println("1. Criar Matriz A");
        System.out.println("2. Criar Matriz B");
        System.out.println("3. Somar Matrizes A + B");
        System.out.println("4. Multiplicar Matriz A por Escalar");
        System.out.println("5. Multiplicação de Matrizes A x B");
        System.out.println("0. Sair");
        System.out.println("---------------------------------");
    }

   
    public static ArrayList<ArrayList<Double>> criarMatriz(Scanner scanner) {
    	System.out.print("Digite o número de linhas (n): ");
        int n = scanner.nextInt();
        System.out.print("Digite o número de colunas (m): ");
        int m = scanner.nextInt();

        if (n <= 0 || m <= 0) {
            System.out.println("Erro: O número de linhas e colunas deve ser positivo.");
            return null; // Retorna null em caso de erro
        }

        ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
        System.out.println("Digite os elementos da matriz (" + n + "x" + m + "):");
        for (int i = 0; i < n; i++) {
            ArrayList<Double> linha = new ArrayList<>();
            System.out.println("Linha " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                linha.add(scanner.nextDouble());
            }
            matriz.add(linha);
        }
        return matriz;
    }

    public static void imprimirMatriz(ArrayList<ArrayList<Double>> matriz) {
        if (matriz == null || matriz.isEmpty()) {
            System.out.println("Matriz vazia ou inválida.");
            return;
        }

        DecimalFormat df = new DecimalFormat("0.00"); // Para garantir 2 casas decimais na impressão

        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                System.out.print(df.format(matriz.get(i).get(j)) + "\t"); // Tab para espaçamento
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }
    }

 
    public static ArrayList<ArrayList<Double>> somarMatrizes(ArrayList<ArrayList<Double>> A, ArrayList<ArrayList<Double>> B) {
        // Verifica se as matrizes são nulas
        if (A == null || B == null) {
            System.out.println("Erro na soma: Matrizes nulas.");
            

            return null;
        }

        // Verifica se as dimensões são compatíveis para soma (mesmo número de linhas e colunas)
        if (A.size() != B.size() || A.get(0).size() != B.get(0).size()) {
            System.out.println("Erro na soma: As matrizes devem ter as mesmas dimensões para serem somadas.");
            return null;
        }

        int n = A.size(); // Número de linhas
        int m = A.get(0).size(); // Número de colunas

        ArrayList<ArrayList<Double>> C = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Double> linhaC = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                linhaC.add(A.get(i).get(j) + B.get(i).get(j));
            }
            C.add(linhaC);
        }
        return C;
    }

  
    public static ArrayList<ArrayList<Double>> multiplicarPorEscalar(ArrayList<ArrayList<Double>> A, double k) {
        if (A == null || A.isEmpty()) {
            System.out.println("Erro na multiplicação por escalar: Matriz nula ou vazia.");
            return null;
        }

        ArrayList<ArrayList<Double>> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Double> linhaC = new ArrayList<>();
            for (int j = 0; j < A.get(i).size(); j++) {
                linhaC.add(A.get(i).get(j) * k);
            }
            C.add(linhaC);
        }
        return C;
    }

  
    public static ArrayList<ArrayList<Double>> multiplicarMatrizes(ArrayList<ArrayList<Double>> A, ArrayList<ArrayList<Double>> B) {
        // Verifica se as matrizes são nulas
    	// ...
        if (A == null || B == null || A.isEmpty() || A.get(0).isEmpty() || B.isEmpty() || B.get(0).isEmpty()) {
            System.out.println("Erro na multiplicação: Matrizes nulas, vazias ou malformadas.");
            return null;
        }
        // ...

        int colunasA = A.get(0).size();
        int linhasB = B.size();

        // Verifica a condição de multiplicabilidade
        if (colunasA != linhasB) {
            System.out.println("Erro na multiplicação: O número de colunas da Matriz A (" + colunasA + ") deve ser igual ao número de linhas da Matriz B (" + linhasB + ").");
            return null;
        }

        int linhasA = A.size();
        int colunasB = B.get(0).size(); // Assume que todas as linhas de B têm o mesmo número de colunas

        ArrayList<ArrayList<Double>> C = new ArrayList<>(); // Matriz resultado (linhasA x colunasB)

        // Inicializa a matriz C com zeros
        for (int i = 0; i < linhasA; i++) {
            ArrayList<Double> linhaC = new ArrayList<>();
            for (int j = 0; j < colunasB; j++) {
                linhaC.add(0.0); // Inicializa com 0.0
            }
            C.add(linhaC);
        }

        // Realiza a multiplicação de matrizes
        for (int i = 0; i < linhasA; i++) { // Para cada linha de A
            for (int j = 0; j < colunasB; j++) { // Para cada coluna de B
                double somaProduto = 0;
                for (int k = 0; k < colunasA; k++) { // k percorre colunas de A e linhas de B
                    somaProduto += A.get(i).get(k) * B.get(k).get(j);
                }
                C.get(i).set(j, somaProduto); // Define o elemento [i][j] da matriz C
            }
        }
        return C;
    }
}
