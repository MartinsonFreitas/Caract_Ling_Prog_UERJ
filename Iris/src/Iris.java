
public class Iris {
	private double comprimento_sepala;
	private double largura_sepala;
	private double comprimento_petala;
	private double largura_pelata;
	private String tipo;
	
	public Iris(double comprimento_sepala, double largura_sepala, double comprimento_petala, double largura_pelata,
			String tipo) {
		this.comprimento_sepala = comprimento_sepala;
		this.largura_sepala = largura_sepala;
		this.comprimento_petala = comprimento_petala;
		this.largura_pelata = largura_pelata;
		this.tipo = tipo;
	}
	public double calcularDistancia(Iris outro) {
		return Math.abs(this.comprimento_sepala - outro.comprimento_sepala) +
				Math.abs(this.largura_sepala - outro.largura_sepala);
	}

	
	@Override
	public String toString() {
		return "Iris [comprimento_sepala = " + comprimento_sepala + ", largura_sepala = " + largura_sepala
				+ ", comprimento_petala = " + comprimento_petala + ", largura_pelata = " + largura_pelata + ", tipo = " + tipo
				+ "]";
	}
	
	
	
}
