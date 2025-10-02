
public class Circulo {
	// Atributos
	private double raio;
	private String cor;
	
	
	// Construtores
	public Circulo() {
		this.raio = 1.0;
		this.cor = "Vermelho";
	}


	public Circulo(double raio) {		
		this.raio = raio;
		this.cor = "Vermelho";
	}


	public Circulo(double raio, String cor) {
		//super();
		this.raio = raio;
		this.cor = cor;
	}

	// Métodos getter e setters
	public double getRaio() {
		return this.raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}
	
	// outros métodos
	public double area() {
		return 	Math.PI*this.raio*this.raio;
	}
	
	public double perimetro() {
		return 2*Math.PI*this.raio;
	}
	
	@Override
	public String toString() {
		return "Circulo [raio: "+ raio + ", cor: "+cor+ " ]"; 
	}
	

}
