package aula_18_09;

public class Teste {

	public static void main(String[] args) {
		
		Conta minhaconta = new Conta();
		minhaconta.titular = "Martinson";
		minhaconta.saldo = 1000;
		
		minhaconta.imprimir();
		minhaconta.deposita(500);
		

	}

}
