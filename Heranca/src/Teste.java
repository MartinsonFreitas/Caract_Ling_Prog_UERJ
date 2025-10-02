
public class Teste {

	public static void main(String[] args) {

		//Cachorro fido = new Cachorro();
		Cachorro fido = new Cachorro("Labrador", 10);
		
		//fido.especie = "Mamifero";
		//fido.peso = 10;
		//fido.raca = "labrador";		
		
		fido.comer();
		fido.emitirSom();
		fido.latir();
		
		//Gato mandaChuva = new Gato("Siamês", 5);
		Gato mandaChuva = new Gato(6);
		
		//mandaChuva.comer();
		mandaChuva.emitirSom();
		//mandaChuva.miar();
		
	}

}
