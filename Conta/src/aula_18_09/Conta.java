package aula_18_09;

public class Conta {
	// atributos
	int numero;
	String titular;
	double saldo;
	
	// métodos
	void deposita(double quantidade) {
		this.saldo += quantidade;	
	}
	
	void saca(double quantidade){
		if(this.saldo >= quantidade) {
			this.saldo -= quantidade;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}
		
	void imprimir(){
		System.out.println("#### Conta ####");
		System.out.println("Número: "+ this.numero);
		System.out.println("Titular: "+ this.titular);
		System.out.println("Saldo: "+this.saldo);
		}
	}

