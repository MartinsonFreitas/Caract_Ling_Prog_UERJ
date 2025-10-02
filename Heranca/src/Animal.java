
public class Animal {
	// Atributos
	protected String especie;
	protected int peso;
	
	// Construtor
	public Animal(String especie, int peso) {
		this.especie = especie;
		this.peso = peso;
	}
	
	
	// métodos
	public void comer() {
		System.out.println("O animal come.");
	}
	public void emitirSom() {
		System.out.println("O animal emite som.");
	}
}
