
public class Gato extends Animal{
	// atributos
		protected String raca;
		
		// construtores
		public Gato(int peso) {
			super("Mamífero", peso); // chama o construtor Animal
			//this.raca = raca;
		}
		
		// métodos
		@Override
		public void emitirSom() {
			System.out.println("Miau Miau...");
		}

}
