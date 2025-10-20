package q6;

/* Q6. Criar um programa que permita analisar o banco de dados Iris e permita criar um
modelo de aprendizado máquina capaz caracterizar uma flor Iris dadas as medidas das pétalas e
sépalas.

O banco de dados está disponível em um arquivo de texto iris.csv (formato csv - valores separados
com vírgulas) disponível no link a seguir:
https://drive.google.com/file/d/1dGHLZoD5-4cnKv2F_tO7Zpw5DxmlA6Ss/view?usp=share_link

Este banco de dados contém um conjunto de 151 linhas com cinco colunas (atributos) listados a seguir:
	●​ Comprimento da sépala
	●​ Largura da sépala,
	●​ Comprimento da pétala,
	●​ Largura da pétala
	●​ Tipo
	
A continuação mostra-se as 4 primeiras linhas do arquivo iris.csv

comprimento_sepala,largura_sepala,comprimento_petala,largura_petala,tipo
	5.1,3.5,1.4,0.2,setosa
	4.9,3.0,1.4,0.2,setosa
	4.7,3.2,1.3,0.2,setosa

A primeira linha contém apenas os nomes das colunas. A partir da segunda linha são armazenados 5
valores (separados por vírgula). Os quatro primeiros valores são numéricos e representam as
dimensões de uma flor íris (em centímetros), o último valor é categórico podendo ser: setosa, versicolor
e virginica. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe que gerencia o banco de dados Iris, permitindo carregamento,
 * impressão, cálculo de estatísticas e a classificação KNN.
 */
public class DBIris {
    public ArrayList<Iris> dataset;

    /**
     * Classe auxiliar para armazenar a distância e o objeto Iris associado
     * para facilitar a ordenação no KNN.
     */
    private static class DistanciaIris {
        double distancia;
        Iris iris;

        public DistanciaIris(double distancia, Iris iris) {
            this.distancia = distancia;
            this.iris = iris;
        }

        public double getDistancia() {
            return distancia;
        }

        public Iris getIris() {
            return iris;
        }
    }

    /**
     * c) Construtor que inicializa o dataset a partir de um arquivo CSV.
     * @param nomeArquivo O caminho para o arquivo CSV.
     */
    public DBIris(String nomeArquivo) {
        this.dataset = new ArrayList<>();
        System.out.println("Carregando o arquivo: " + nomeArquivo + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Pula a linha do cabeçalho
            if (br.readLine() == null) {
                throw new IOException("O arquivo está vazio ou não pôde ser lido.");
            }

            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    String[] atributos = linha.split(",");

                    if (atributos.length < 5) {
                        System.err.println("Linha ignorada (formato inválido): " + linha);
                        continue;
                    }

                    // Conversão dos atributos numéricos
                    double comp_sepala = Double.parseDouble(atributos[0].trim());
                    double lar_sepala = Double.parseDouble(atributos[1].trim());
                    double comp_petala = Double.parseDouble(atributos[2].trim());
                    double lar_pelata = Double.parseDouble(atributos[3].trim());
                    String tipo = atributos[4].trim();

                    this.dataset.add(new Iris(comp_sepala, lar_sepala, comp_petala, lar_pelata, tipo));

                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter um valor numérico na linha: " + linha + ". Detalhes: " + e.getMessage());
                }
            }
            System.out.println("Carregamento concluído. " + this.dataset.size() + " elementos carregados.");

        } catch (IOException e) {
            System.err.println("O arquivo " + nomeArquivo + " não foi encontrado ou não pôde ser lido. Erro: " + e.getMessage());
            this.dataset = null; // Indica falha no carregamento
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado durante o carregamento: " + e.getMessage());
            this.dataset = null;
        }
    }

    /**
     * c) Imprime todos os elementos do dataset.
     */
    public void imprimir() {
        if (this.dataset == null || this.dataset.isEmpty()) {
            System.out.println("Dataset vazio ou não carregado.");
            return;
        }
        System.out.println("\n--- Elementos do Dataset ---");
        for (Iris iris : dataset) {
            System.out.println(iris.toString());
        }
        System.out.println("\n----------------------------\n");
    }

    /**
     * d) Calcula e imprime estatísticas básicas para os atributos numéricos e frequência para o atributo tipo.
     */
    public void calcularEstatisticas() {
        if (this.dataset == null || this.dataset.isEmpty()) {
            System.out.println("Dataset vazio. Não é possível calcular estatísticas.");
            return;
        }

        int totalElementos = this.dataset.size();
        System.out.println("\n--- Resumo base de dados iris: " + totalElementos + " elementos ---\n");

        // Extração dos valores em listas para facilitar os cálculos
        List<Double> cs = this.dataset.stream().map(Iris::getComprimento_sepala).collect(Collectors.toList());
        List<Double> ls = this.dataset.stream().map(Iris::getLargura_sepala).collect(Collectors.toList());
        List<Double> cp = this.dataset.stream().map(Iris::getComprimento_petala).collect(Collectors.toList());
        List<Double> lp = this.dataset.stream().map(Iris::getLargura_pelata).collect(Collectors.toList());
        
        // Frequência do tipo
        Map<String, Integer> tipoFrequencia = new HashMap<>();
        for (Iris iris : dataset) {
            tipoFrequencia.put(iris.getTipo(), tipoFrequencia.getOrDefault(iris.getTipo(), 0) + 1);
        }

        // Funções auxiliares para cálculo e impressão
        this.imprimirEstatisticas(cs, "comprimento_sepala");
        this.imprimirEstatisticas(ls, "largura_sepala");
        this.imprimirEstatisticas(cp, "comprimento_petala");
        this.imprimirEstatisticas(lp, "largura_pelata");

        // Estatísticas para o atributo tipo
        System.out.println("tipo:");
        for (Map.Entry<String, Integer> entry : tipoFrequencia.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " ocorrências");
        }
    }

    /**
     * Calcula e imprime Min, Max, Média e Desvio Padrão para uma lista de doubles.
     */
    private void imprimirEstatisticas(List<Double> valores, String nomeAtributo) {
        if (valores.isEmpty()) {
            System.out.println(nomeAtributo + ": Dados indisponíveis.");
            return;
        }

        double min = Collections.min(valores);
        double max = Collections.max(valores);

        double soma = 0.0;
        for (double val : valores) {
            soma += val;
        }
        double media = soma / valores.size();

        double somaQuadradosDiferencas = 0.0;
        for (double val : valores) {
            somaQuadradosDiferencas += Math.pow(val - media, 2);
        }
        // Desvio Padrão Amostral (divisão por N-1)
        double variancia = somaQuadradosDiferencas / (valores.size() > 1 ? valores.size() - 1 : 1); 
        double desvioPadrao = Math.sqrt(variancia);

        System.out.println(nomeAtributo + ":");
        System.out.printf("  Minimo: %.3f\n", min);
        System.out.printf("  Maximo: %.3f\n", max);
        System.out.printf("  Média: %.3f\n", media);
        System.out.printf("  Desvio padrão: %.3f\n\n", desvioPadrao);
    }


    /**
     * e) Implementa o algoritmo K-Nearest Neighbors (KNN).
     * @param novaIris O objeto Iris de entrada (com tipo="?").
     * @param k O número de vizinhos mais próximos a considerar.
     * @return O tipo (classe) predito.
     */
    public String knn(Iris novaIris, int k) {
        if (this.dataset == null || this.dataset.isEmpty()) {
            return "Erro: Dataset vazio ou não carregado.";
        }
        if (k <= 0 || k > this.dataset.size()) {
            return "Erro: O valor de K ("+k+") é inválido para um dataset de tamanho " + this.dataset.size() + ".";
        }

        List<DistanciaIris> distancias = new ArrayList<>();

        // 1. Calcula a distância de Manhattan do objeto de entrada com todos os elementos da base
        for (Iris iris : dataset) {
            double distancia = novaIris.calcularDistancia(iris);
            distancias.add(new DistanciaIris(distancia, iris));
        }

        // 2. Ordena os valores das distâncias (de menor a maior)
        Collections.sort(distancias, Comparator.comparingDouble(DistanciaIris::getDistancia));

        // 3. Verifica qual é o tipo majoritário nos primeiros k elementos
        Map<String, Integer> contagemTipos = new HashMap<>();
        
        // Considera apenas os primeiros k vizinhos
        for (int i = 0; i < k; i++) {
            String tipoVizinho = distancias.get(i).getIris().getTipo();
            contagemTipos.put(tipoVizinho, contagemTipos.getOrDefault(tipoVizinho, 0) + 1);
        }

        // Encontra o tipo majoritário
        String classePredita = "Indeterminado";
        int maxContagem = -1;

        for (Map.Entry<String, Integer> entry : contagemTipos.entrySet()) {
            if (entry.getValue() > maxContagem) {
                maxContagem = entry.getValue();
                classePredita = entry.getKey();
            }
        }

        return classePredita;
    }
}