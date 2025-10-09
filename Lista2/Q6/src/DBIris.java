import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBIris {
    private List<Iris> dataset;

    public DBIris(String filePath) {
        this.dataset = new ArrayList<>();
        carregarDataset(filePath);
    }

    private void carregarDataset(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Pula a primeira linha (cabeçalho)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    double comprimento_sepala = Double.parseDouble(data[0]);
                    double largura_sepala = Double.parseDouble(data[1]);
                    double comprimento_petala = Double.parseDouble(data[2]);
                    double largura_petala = Double.parseDouble(data[3]);
                    String tipo = data[4];
                    dataset.add(new Iris(comprimento_sepala, largura_sepala, comprimento_petala, largura_petala, tipo));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dataset: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato numérico no dataset: " + e.getMessage());
        }
    }

    public void imprimir() {
        System.out.println("--- Dataset Iris ---");
        for (Iris iris : dataset) {
            System.out.println(iris);
        }
        System.out.println("--------------------");
    }

    public void calcularEstatisticas() {
        if (dataset.isEmpty()) {
            System.out.println("Dataset vazio. Não é possível calcular estatísticas.");
            return;
        }

        System.out.println("\nResumo base de dados iris: " + dataset.size() + " elementos");

        // Atributos numéricos
        String[] atributosNumericos = {"comprimento_sepala", "largura_sepala", "comprimento_petala", "largura_petala"};
        for (String atributo : atributosNumericos) {
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            double sum = 0;
            List<Double> valores = new ArrayList<>();

            for (Iris iris : dataset) {
                double valor = 0;
                switch (atributo) {
                    case "comprimento_sepala": valor = iris.getComprimento_sepala(); break;
                    case "largura_sepala": valor = iris.getLargura_sepala(); break;
                    case "comprimento_petala": valor = iris.getComprimento_petala(); break;
                    case "largura_petala": valor = iris.getLargura_petala(); break;
                }
                min = Math.min(min, valor);
                max = Math.max(max, valor);
                sum += valor;
                valores.add(valor);
            }

            double media = sum / dataset.size();
            double sumOfSquares = 0;
            for (double valor : valores) {
                sumOfSquares += Math.pow(valor - media, 2);
            }
            double desvioPadrao = Math.sqrt(sumOfSquares / (dataset.size() - 1)); // Amostral

            System.out.println(atributo + ":");
            System.out.println("Minimo: " + String.format("%.3f", min));
            System.out.println("Maximo: " + String.format("%.3f", max));
            System.out.println("Média: " + String.format("%.3f", media));
            System.out.println("Desvio padrão: " + String.format("%.3f", desvioPadrao));
        }

        // Atributo tipo (frequência)
        Map<String, Integer> frequenciaTipos = new HashMap<>();
        for (Iris iris : dataset) {
            frequenciaTipos.put(iris.getTipo(), frequenciaTipos.getOrDefault(iris.getTipo(), 0) + 1);
        }
        System.out.println("tipo:");
        for (Map.Entry<String, Integer> entry : frequenciaTipos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ocorrências");
        }
    }

    public String knn(Iris iris, int k) {
        if (dataset.isEmpty()) {
            return "Dataset vazio. Não é possível aplicar KNN.";
        }

        // Calcular distâncias
        List<Map.Entry<Iris, Double>> distancias = new ArrayList<>();
        for (Iris dataIris : dataset) {
            distancias.add(new HashMap.SimpleEntry<>(dataIris, iris.calcularDistancia(dataIris)));
        }

        // Ordenar por distância
        Collections.sort(distancias, Comparator.comparingDouble(Map.Entry::getValue));

        // Contar tipos dos k vizinhos mais próximos
        Map<String, Integer> contagemTipos = new HashMap<>();
        for (int i = 0; i < k && i < distancias.size(); i++) {
            String tipoVizinho = distancias.get(i).getKey().getTipo();
            contagemTipos.put(tipoVizinho, contagemTipos.getOrDefault(tipoVizinho, 0) + 1);
        }

        // Encontrar o tipo majoritário
        String tipoMajoritario = null;
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : contagemTipos.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                tipoMajoritario = entry.getKey();
            }
        }
        return tipoMajoritario;
    }
}
