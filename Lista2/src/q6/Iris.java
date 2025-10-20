package q6;

/**
 * Classe que representa uma instância da flor Iris, com atributos dimensionais
 * e o seu tipo (classe).
 */
public class Iris {
    private double comprimento_sepala;
    private double largura_sepala;
    private double comprimento_petala;
    private double largura_pelata;
    private String tipo;

    /**
     * Construtor para inicializar todos os atributos.
     */
    public Iris(double comprimento_sepala, double largura_sepala, double comprimento_petala, double largura_pelata,
                String tipo) {
        this.comprimento_sepala = comprimento_sepala;
        this.largura_sepala = largura_sepala;
        this.comprimento_petala = comprimento_petala;
        this.largura_pelata = largura_pelata;
        this.tipo = tipo;
    }

    // --- Métodos Getters ---
    public double getComprimento_sepala() {
        return comprimento_sepala;
    }

    public double getLargura_sepala() {
        return largura_sepala;
    }

    public double getComprimento_petala() {
        return comprimento_petala;
    }

    public double getLargura_pelata() {
        return largura_pelata;
    }

    public String getTipo() {
        return tipo;
    }

    // --- Métodos Setters ---
    public void setComprimento_sepala(double comprimento_sepala) {
        this.comprimento_sepala = comprimento_sepala;
    }

    public void setLargura_sepala(double largura_sepala) {
        this.largura_sepala = largura_sepala;
    }

    public void setComprimento_petala(double comprimento_petala) {
        this.comprimento_petala = comprimento_petala;
    }

    public void setLargura_pelata(double largura_pelata) {
        this.largura_pelata = largura_pelata;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * b) Calcula a distância de Manhattan entre esta instância Iris e outra.
     * distancia (iris1, iris2) = |CS1 - CS2| + |LS1 - LS2| + |CP1 - CP2| + |LP1 - LP2|
     * (Assumindo que o último termo era |LP1 - LP2|).
     */
    public double calcularDistancia(Iris outro) {
        return Math.abs(this.comprimento_sepala - outro.comprimento_sepala) +
               Math.abs(this.largura_sepala - outro.largura_sepala) +
               Math.abs(this.comprimento_petala - outro.comprimento_petala) +
               Math.abs(this.largura_pelata - outro.largura_pelata);
    }

    /**
     * a) Retorna uma string concatenando os valores dos atributos separados por vírgula.
     * Exemplo: 5.1,3.5,1.4,0.2,setosa
     */
    @Override
    public String toString() {
        return this.comprimento_sepala + "," +
               this.largura_sepala + "," +
               this.comprimento_petala + "," +
               this.largura_pelata + "," +
               this.tipo;
    }
}