package aula_15_09;

public class Teste {

	public static void main(String[] args) {
				
		Endereco end1 = new Endereco();
		end1.rua = "Av. Visconde";
		end1.numero = 50;
		end1.bairro = "Centro";
		
		//end1.imprimir();
		
		Pessoa p1 = new Pessoa();
		p1.nome = "Martinson";
		p1.idade = 50;
		p1.end = end1;
		
		//System.out.println("End.: "+ end1.rua + ", "+ end1.numero + " - "+ end1.bairro);
		//System.out.println(p1.end.bairro);
		
		p1.imprimir();
		p1.aniversariar();
		p1.imprimir();
	}

}
