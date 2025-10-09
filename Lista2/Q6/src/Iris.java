public class Iris {
    private double comprimento_sepala;
    private double largura_sepala;
    private double comprimento_petala;
    private double largura_petala;
    private String tipo;

    public Iris(double comprimento_sepala, double largura_sepala, double comprimento_petala, double largura_petala, String tipo) {
        this.comprimento_sepala = comprimento_sepala;
        this.largura_sepala = largura_sepala;
        this.comprimento_petala = comprimento_petala;
        this.largura_petala = largura_petala;
        this.tipo = tipo;
    }

    // Getters
    public double getComprimento_sepala() {
        return comprimento_sepala;
    }

    public double getLargura_sepala() {
        return largura_sepala;
    }

    public double getComprimento_petala() {
        return comprimento_petala;
    }

    public double getLargura_petala() {
        return largura_petala;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setComprimento_sepala(double comprimento_sepala) {
        this.comprimento_sepala = comprimento_sepala;
    }

    public void setLargura_sepala(double largura_sepala) {
        this.largura_sepala = largura_sepala;
    }

    public void setComprimento_petala(double comprimento_petala) {
        this.comprimento_petala = comprimento_petala;
    }

    public void setLargura_petala(double largura_petala) {
        this.largura_petala = largura_petala;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("%.1f,%.1f,%.1f,%.1f,%s",
                comprimento_sepala, largura_sepala, comprimento_petala, largura_petala, tipo);
    }

    public double calcularDistancia(Iris outroIris) {
        return Math.abs(this.comprimento_sepala - outroIris.getComprimento_sepala()) +
               Math.abs(this.largura_sepala - outroIris.getLargura_sepala()) +
               Math.abs(this.comprimento_petala - outroIris.getComprimento_petala()) +
               Math.abs(this.largura_petala - outroIris.getLargura_petala());
    }
}
