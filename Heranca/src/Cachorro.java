
public class Cachorro extends Animal{
	// atributos
	protected String raca;
	
	// construtores
	public Cachorro(String raca, int peso) {
		super("Mamífero", peso); // chama o construtor Animal
		this.raca = raca;
	}
	
	// métodos
	public void latir() {
		System.out.println("Au au...");
	}
}
