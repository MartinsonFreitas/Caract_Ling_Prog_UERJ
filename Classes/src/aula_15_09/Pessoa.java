package aula_15_09;

public class Pessoa {
	String nome;
	int idade;
	Endereco end;
	
	// Mérodos
	void aniversariar() {
		this.idade = this.idade + 1;
		//idade = idade + 1;
	}
	
	void imprimir() {
		System.out.println("#### Dados Pessoais ####");
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Endereço: ");		
		this.end.imprimir();
		System.out.println("");
	}

}
