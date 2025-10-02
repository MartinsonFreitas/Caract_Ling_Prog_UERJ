
public class Teste {

	public static void main(String[] args) {
		Contador c1 = new Contador();
		Contador c2 = new Contador();
		Contador c3 = new Contador();
		
		// métodos publicos
		c1.mostrarContagem();
		c2.mostrarContagem();
		
		// método estático
		Contador.mostrarContagem();
	}

}
